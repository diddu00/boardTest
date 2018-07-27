<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>www.webmadang.net</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<script language="javascript">

var oTbl;
//Row 추가
function insRow() {
  oTbl = document.getElementById("addTable");
  var oRow = oTbl.insertRow();
  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex}; //clickedRowIndex - 클릭한 Row의 위치를 확인;
  var oCell = oRow.insertCell();

  //삽입될 Form Tag
  var frmTag = "<input type=\"file\" id=\"uploadFile\" name=\"uploadFile\"/>";
  frmTag += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
  oCell.innerHTML = frmTag;
}
//Row 삭제
function removeRow() {
  oTbl.deleteRow(oTbl.clickedRowIndex);
}

function frmCheck()
{
  var frm = document.form;
  
  for( var i = 0; i <= frm.elements.length - 1; i++ ){
     if( frm.elements[i].name == "uploadFile" )
     {
         if( !frm.elements[i].value ){
             alert("첨가파일을 선택하지 않았습니다.");
                 frm.elements[i].focus();
	 return;
          }
      }
   }
 }

</script>
</head>
<body>
<form name="form" method="post">
<table width="400" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" bgcolor="#FFFFFF">
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
         <td colspan="5" bgcolor="#FFFFFF" height="25" align="left">
         <input name="addButton" type="button" style="cursor:hand" onClick="insRow()" value="추가">
         <font color="#FF0000">*</font>추가버튼을 클릭해 보세요.</td>
        </tr>
        <tr>
         <td height="25">
           <table id="addTable" width="400" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" border="0">
            <tr>
              <td align="left"></td>
            </tr>
          </table></td>
        </tr>
       </table>
      </td>
   </tr>
 </table>
 <table width="400" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="10">
      </td>
    </tr>
    <tr>
      <td align="center">
      <input type="button" name="button" value="확인" onClick="frmCheck();">
      </td>
    </tr>
 </table>
</form>
</body>
</html>