$(function(){
  var user=document.cookie.match(/user=(.*?)(;|$)/)[1];
  $("#button").click(
    function(){
      $.ajax({
        type:'POST',
        url:'../login/chPwd',
        dataType:'json',
        contentType:"application/json",
        data:JSON.stringify({user:user,old:$("#old").val(),_new:$("#new").val()}),
        success:function (data){
          if(data.code=="00000"){
            alert("修改密码成功");
            window.location.href="norManage.html";
          }
          else if(data.code=="00006"){
            alert("原始密码错误");
            $("#old").focus().val("");
          }
        }

      })
    }
  );
  $("#reNew").change(function(){
    if($("#new").val()!=$("#reNew").val()){
      $(".tip").attr('style','display:block');
      $("#reNew").val("");
      $("#button").attr("disabled","disabled");
    }
    else {
      $("#button").removeAttr("disabled");
      $(".tip").attr('style','display:none');
    }
  });
})
