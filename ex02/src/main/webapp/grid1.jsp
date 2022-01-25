<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<link rel="stylesheet" href="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script	src="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<style>
	.cur_row { background-color: 'gray';}
</style>	
</head>
<body>
<div class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
	<input id="txtCo"><button id="btnFindCo">��ü�˻�</button>
	<input id="txtEmp"><button id="btnFindEmp">����˻�</button>
	<div id="dialog-form" title="����׽�Ʈ">     </div>
	<div>
		<button type="button" id="btnFind">��ȸ</button>
		<button type="button" id="btnRst">�ʱ�ȭ</button>
		<button type="button" id="btnAdd">�߰�</button>
		<button type="button" id="btnDel">����</button>
		<button type="button" id="btnSave">����</button>
	</div>
	<div id="grid"></div>
	<script>
	let codes ={ "st" : [
        { text: 'IE 9', value: "1" },
        { text: 'IE 10', value: "2" },
        { text: 'IE 11', value: "3" },
        { text: 'Firefox', value: "4" },
        { text: 'Chrome', value: "5" }
      ],
      "crud" : [
          { text: '���', value: "c" },
          { text: '��ȸ', value: "r" },
          { text: '����', value: "u" },
          { text: '����', value: "d" }
        ]}
	
		function selectCo(co){
			var curcell = grid.getFocusedCell();
			grid.setValue(curcell.rowKey, curcell.columnName, co);
			$("#txtCo").val(co);
			dialog.dialog( "close" );
		}
		
		let dialog = $( "#dialog-form" ).dialog({
			autoOpen: false,
			modal:true,
			buttons : {
				'����' :function(){
					grid.setValue(0, 'city','test')
					grid.setValue(0, 'wdate','2022-12-01')
					dialog.dialog( "close" );
				}
			}
		});
		
		$("#btnFindCo").on("click", function(){
			dialog.dialog( "open" );
			$("#dialog-form").load("searchCo.jsp",
					function(){console.log("�ε��")})
		});
		
		var Grid = tui.Grid;
		Grid.applyTheme('striped',{
			cell:{
				header:{
					backgound:'#eef'
				},
				evenRow:{
					background:'#fee'
				}
				,disabled {
					background:'#fee',
					text : ''
				}
			}
		}) 
		Grid.applyTheme('custom', { 
		/* 	  row: { 
			    hover: { 
			      background: '#00eeff' 
			    }
			  }, */
			  selection : {
				  background: 'gray' 
			  },
			  cell : {
				  focused : {
					   background: 'gray'  
				  },
				  currentRow : { 
				      background: 'gray' 
				    }
			  }
			});
	const columns = [ {
			header : 'ID',
			name : 'id'
		}, {
			header : 'CITY',
			name : 'city',
			editor : 'text'
		}, {
			header : 'COUNTRY',
			name : 'country'
		},{
			header : '�۾�����',
			name : 'wdate',
			editor : 'datePicker'
		},{
		    header: 'BROWSER',
		    name: 'browser',
		    formatter: 'listItemText',
		    editor: {
		      type: 'select',
		      options: { listItems: codes.st }
		    }        
		  },{
			    header: 'CRUD',
			    name: 'crud',
			    align : 'center',
			    formatter: 'listItemText',
			    editor: {
			      type: 'select',
			      options: { listItems: codes.crud }
			    }        
			  } ];
		
		let data;
		const dataSource = {
				  api: {
				    readData: { 
				    	url: '${pageContext.request.contextPath}/resources/json/city.json', 
				    	method: 'GET', 
				    	initParams: { param: 'param' } 
				    },
				    modifyData:{
				    	url :'${pageContext.request.contextPath}/modifyData',
				    	method:'PUT'
				    }
				  },
				  contentType:'application/json'
				};
		
		const grid = new Grid({
			  el: document.getElementById('grid'),
			  data:dataSource,
			  rowHeaders :['checkbox'],
			  columns,
			  columnOptions: {
				    frozenCount: 3, 
				    frozenBorderWidth: 2 
				  }
			});
		
		//grid.disableColumn("crud");
		
		grid.on('beforeChange',function(ev){
			if(ev.columnName == "crud") {
				return false;
			}
		})
		
		grid.on('click', (ev) => {	
		    console.log(ev);
		    console.log(ev.nativeEvent);
			if(ev.columnName == "crud") {
				$("#btnFindCo").click();
			}
		})
			
		grid.on('response',function(ev){
			
				console.log("response",ev);
				grid.resetOriginData();
		});

		btnFind.addEventListener("click",function(){
			grid.readData(   );
		});
		btnRst.addEventListener("click",function(){
			grid.restore();
		})
		btnAdd.addEventListener("click",function(){
			grid.appendRow({});
		});
		btnDel.addEventListener("click",function(){
			grid.removeCheckedRows(true);
		});
		btnSave.addEventListener("click",function(ev){
			grid.blur();
			if(confirm("�����ұ��")) {				
				grid.request('modifyData', {showConfirm:false});
			}
		});
	</script>
	
</body>
</html>