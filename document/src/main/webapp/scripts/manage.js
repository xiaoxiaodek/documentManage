$(function(){
    var user=document.cookie.slice(document.cookie.lastIndexOf("=")+1);
    param={"user":user};
    $.ajax({
        type:"POST",   //http请求方式
        url:"../manage/show", //发送给服务器的url
        data:JSON.stringify(param),
        //JSON.stringify(param), //发送给服务器的参数
        dataType:"json",
        contentType:"application/json",
        success:function(data) {
        	returnresult = data.data;
        	showtable(returnresult);
        }
    });
    function showtable(returnresult){
    if(returnresult.length <= 0) {
        var nodata = "<tr><td colspan = '6'>没有数据</td></tr>";
        $("#msgtable").html(nodata);
    } else {
      var hidhtml="";
      for(var i=0; i<returnresult.length; i++){
          hidhtml= hidhtml +"<tr id=' "+returnresult[i].id+" '><td><input type='checkbox' class='msg' name=' "+returnresult[i].id+
          " '></td><td>"+returnresult[i].name+
          "</td><td>"+returnresult[i].type+"</td><td>"+returnresult[i].discription+
          "</td><td>"+returnresult[i].path+"</td></tr>";
      }
      $("#hidden-table").html(hidhtml);

    $("#Pagination").pagination(returnresult.length, {
        num_edge_entries: 1, //边缘页数
        num_display_entries: 4, //主体页数
        callback: pageselectCallback,
        items_per_page: 5, //每页显示5项
        prev_text: "前一页",
        next_text: "后一页"
    });

    }
}

    function pageselectCallback(page_index,jq){
      //  template method of yourself
      debugger;
         var html = "";
         $("#msgtable").empty();
         for(var i=page_index*5;i<(page_index+1)*5; i++){

            var new_content = $("#hidden-table tr:eq("+i+")").clone();
        		$("#msgtable").append(new_content); //装载对应分页的内容
         }
       }
      //  $("#btn_manage").on("click","a",function(e){
      //    switch(e.currentTarget.id){
      //      case btn_upload:
      //        upload();
      //        break;
      //    }
      //  })
      //  function upload(){
      //
       //
      //  }
      $("#btn_upload").click(function(){
        var formData=new FormData;
        formData.append("file",$("#file")[0].files[0]);
        $.ajax({
                url: '/file/doc/',
                type: 'POST',
                cache: false,
                data: formData,
                processData: false,
                contentType: false
            }).done(function(res) {
              alert(success);
            }).fail(function(res) {});
        })

})
//[{name: "算法", path: "/file", discription: "十分", type: "psf"}]
//$('#file')[0].files[0]
