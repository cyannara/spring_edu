<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<link rel="stylesheet" href="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.css" />
<script	src="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="./resources/basic-dummy.js"></script>
<style>
	.tui-grid-cell img {
	width :50px;}
	.someClassName  { background-color: red ; color:white; font-size: 1.5em}
	.rowBlue { background-color: blue  !important ; color:white  !important }
</style>
</head>
<body>
<div class="rowBlue">test</div>
<div id="grid"></div>

<script>

//콤마넣기
function commaFormatter(cell) {
    var str = String(cell.value);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

// 콤마풀기
function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');

}

function imgFormatter(cell){
	var str = String(cell.value);
	return `<img src='http://image.bugsm.co.kr/album/images/200/\${str.substr(0,4)}/\${cell.value}.jpg'>`;
}
class NumberRenderer {
	  constructor(props) {
	    const el = document.createElement('input');
	    const { grid, rowKey, columnInfo } = props;

	    el.type = 'number';

	    el.addEventListener('mousedown', (ev) => {
	      ev.stopPropagation();
	    });

	    el.addEventListener('change', () => {
	      grid.setValue(rowKey, columnInfo.name, Number(el.value));
	    });

	    this.el = el;
	    this.render(props);
	  }

	  getElement() {
	    return this.el;
	  }

	  render(props) {
		const str = String(props.value);
	    this.el.value = str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');;
	  }
}
	var Grid = tui.Grid;
	
	//Grid.applyTheme('clean')
	
    const grid = new tui.Grid({
        el: document.getElementById('grid'),
        data: gridData,
        scrollX: false,
        scrollY: false,
 /*        pageOptions: {
            perPage: 10
          }, */
        columns: [
          {
        	header : '커버이미지',
        	name : 'id',
        /* 	formatter : imgFormatter */
          },	
          {
            header: 'Name',
            name: 'name'
          },
          {
            header: 'Artist',
            name: 'artist'
          },
          {
            header: 'Type',
            name: 'type'
          },
          {
            header: 'Release',
            name: 'release',
            editor: {
                type: 'datePicker',
                options: {
                  format: 'yyyy.MM.dd'
                }
              }
          },
          {
            header: 'Genre',
            name: 'genre'
          },
          {
              header: '가격',
              name: 'price',
              formatter : commaFormatter,
              editor : 'text'
          }
        ]
      });
    
    
    let selectedRowKey = null;
    grid.on('focusChange', ev => {
    	console.log(selectedRowKey)
      if (selectedRowKey) {
        grid.removeRowClassName(selectedRowKey, 'someClassName');
      }
      selectedRowKey = ev.rowKey;
      grid.addRowClassName(selectedRowKey, 'someClassName');
    });
    
/*     formatter: function(value) {
        var albumId = value.toString();
        var imageId = albumId.substring(0, albumId.length - 2);
        var url = 'http://image.bugsm.co.kr/album/images/200/' + imageId + '/' + albumId + '.jpg'

        return '<img src="' + url + '" width="40" height="40" />';
    } */
</script>
</body>
</html>