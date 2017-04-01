$(function(){
    var user=document.cookie.match(/user=(.*?)(;|$)/)[1];
    var param={"user":user};
    // $.ajax({
    //     type:"POST",   //http请求方式
    //     url:"../manage/show", //发送给服务器的url
    //     data:JSON.stringify(param),
    //     //JSON.stringify(param), //发送给服务器的参数
    //     dataType:"json",
    //     contentType:"application/json",
    //     success:function(data) {
    //     	returnresult = data.data;
    //     	showtable(returnresult);
    //     }
    // });
    searchData(param);
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
          "</td><td>"+returnresult[i].upTime+"</td><td><a download='' href='../file/doc/"+returnresult[i].name+"'>下载</a></td><td><a index='"+returnresult[i].id+"'>删除</a></td></tr>";
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
      $("#btn_upload").click(function(){
        var date=new Date();
        var formData=new FormData;
        var s={"info":$("#discription").val(),"user":user,"date":date.toLocaleDateString().replace(/\//g,"-")}
        formData.append("file",$("#file")[0].files[0]);
        formData.append("s",JSON.stringify(s));
        $.ajax({
                url: '/manage/upLoadDoc',
                type: 'POST',
                cache: false,
                data: formData,
                processData: false,
                contentType: false
            }).success(function(res) {
              debugger;
              var status=res.code;
              if(status==00007){
                alert("数据出错");
              }
              else if(status==00000){
                alert("上传成功");
                $("#myModal").hide();
                window.location.reload();
              }
            }).fail(function(res) {alert("error");});
        })

        function searchData(param){
          debugger;
          $.ajax({
            url:"/manage/show",
            type:"POST",
            data:JSON.stringify(param),
            dataType:"json",
            contentType:"application/json",
            success:function(data){
              showtable(data.data);
            },
            error:function(data){
              alert("error");
            }
          })
        }
      $("#search").click(function(){
        var seo=$("#seo").val();
        param.seo=seo;
        searchData(param);
      })
      $("#btn_edit").click(function(){
        var  checked=$('input.msg:checked');
        var change=$('#discriptionCg');
        if(checked.length==1){
          $.ajax({
            type:"POST",
            url:"/manage/chDiscription",
            data:JSON.stringify({'user':user,'id':parseInt(checked[0].name),'change':change.val()}),
            dataType:"json",
            contentType:"application/json",
            success:function(data){
              if(data.msg==""){
                alert("修改成功");
                $("#editModal").hide();
                window.location.reload();
              }else {
                alert("error");
                $("#editModal").hide();
              }
            }
          })
        }else {
          alert("只能修改一项");
        }
      })
      $("#btn_delete").click(function(){
        var  checked=$('input.msg:checked');
        var id=[];
        for(var i=0;i<checked.length;i++){
          id.push(parseInt(checked[i].name));
        }
        if(checked.length){
          $.ajax({
            type:"POST",
            url:"/manage/delete",
            data:JSON.stringify({'user':user,'id':id}),
            dataType:"json",
            contentType:"application/json",
            success:function(data){
              if(data.msg==""){
                alert("删除成功");
                window.location.reload();
              }else {
                alert("error");
              }
            }
          })
        }else{
          alert("未选中文件")
        }
      })

})
//[{name: "算法", path: "/file", discription: "十分", type: "psf"}]
//$('#file')[0].files[0]
