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
      debugger
    if(returnresult.length <= 0) {
      $(".msgtable").empty();
        var nodata = "<div style='color:red;margin:0 auto;'>没有数据</div>";
        $(".msgtable").html(nodata);
    } else {
      var hidhtml="";
      // for(var i=0; i<returnresult.length; i++){
      //     hidhtml= hidhtml +"<tr id=' "+returnresult[i].id+" '><td><input type='checkbox' class='msg' name=' "+returnresult[i].id+
      //     " '></td><td>"+returnresult[i].name+"</td><td>"+returnresult[i].label+
      //     "</td><td>"+returnresult[i].type+"</td><td>"+returnresult[i].discription+
      //     "</td><td>"+returnresult[i].path+"</td><td><a download='' href='../file/book/"+returnresult[i].name+"'>下载</a></td><td><a index='"+returnresult[i].id+"'>删除</a></td></tr>";
      // }

      for(var i=0; i<returnresult.length; i++){
        debugger;
          hidhtml= hidhtml +"<div class='content'><div class='picture'><img src='http://img62.ddimg.cn/digital/product/23/14/1960072314_ii_cover.jpg?version=f74b40ea-4705-43e1-96c7-2731814d3263' alt=''></div><div class='menu'><dl><dt><a download='' href='../file/book/"+returnresult[i].name+"'><strong>"
          +returnresult[i].name+"</strong></a></dt><dd><small>"+returnresult[i].label+"</small></dd><dd><small>"+returnresult[i].discription+"</small></dd></dl></div><input type='checkbox' class='msg' name='"+returnresult[i].id+"'/></div>";}
      $("#hidden-table").html(hidhtml);

    $("#Pagination").pagination(returnresult.length, {
        num_edge_entries: 1, //边缘页数
        num_display_entries: 4, //主体页数
        callback: pageselectCallback,
        items_per_page: 6, //每页显示6项
        prev_text: "前一页",
        next_text: "后一页"
    });

    }
}

    // function pageselectCallback(page_index,jq){
    //   //  template method of yourself
    //   debugger;
    //      var html = "";
    //      $("#msgtable").empty();
    //      for(var i=page_index*5;i<(page_index+1)*5; i++){
    //
    //         var new_content = $("#hidden-table tr:eq("+i+")").clone();
    //     		$("#msgtable").append(new_content); //装载对应分页的内容
    //      }
    //    }
    function pageselectCallback(page_index,jq){
      //  template method of yourself
      debugger;
         var html = "";
         $(".msgtable").empty();
         for(var i=page_index*6;i<(page_index+1)*6; i++){
            var new_content = $("#hidden-table .content:eq("+i+")").clone();
        		$(".msgtable").append(new_content); //装载对应分页的内容
         }
       }
      $("#btn_upload").click(function(){
        var formData=new FormData;
        var s={"info":$("#discription").val(),"user":user,"type":$("#type").val()}
        formData.append("file",$("#file")[0].files[0]);
        formData.append("s",JSON.stringify(s));
        $.ajax({
                url: '/manage/upLoadBook',
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
            url:"/manage/showBooks",
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
        var seoType=$("#seoType").val();
        param.seo=seo;
        param.seoType=seoType;
        searchData(param);
      })
      $("#btn_edit").click(function(){
        var  checked=$('input.msg:checked');
        var change=$('#discriptionCg');
        if(checked.length==1){
          $.ajax({
            type:"POST",
            url:"/manage/chBookDiscription",
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
            url:"/manage/deleteBook",
            data:JSON.stringify({'user':user,'id':id}),
            dataType:"json",
            contentType:"application/json",
            success:function(data){
              if(data.msg==""){
                alert("删除成功");
                window.location.reload();
              }else {
                alert("error");
                window.location.reload();
              }
            }
          })
        }else{
          alert("未选中文件")
        }
      })
      $($(".side li")[0]).click(function(){
        $(".side-type").toggleClass("hidden");
      })
      $($(".side li")[1]).click(function(){
        $(".side-label").toggleClass("hidden");
      })
      $($(".side li")[2]).click(function(){
        searchData(param);
      })

      $(".side-type").on('click','a',function(){
        // console.log($(this).attr('value'));
        $.ajax({
          type:"POST",
          url:"/manage/otherSearch",
          data:JSON.stringify({'user':user,'value':$(this).attr('value'),'index':"type"}),
          dataType:"json",
          contentType:"application/json",
          success:function(data){
            if(data.msg==""){
              showtable(data.data);
            }else {
              alert("error");
              window.location.reload();
            }
          }
        })
      })

      $(".side-label").on('click','a',function(){
        console.log($(this).attr('value'));
        $.ajax({
          type:"POST",
          url:"/manage/otherSearch",
          data:JSON.stringify({'user':user,'value':$(this).attr('value'),'index':"label"}),
          dataType:"json",
          contentType:"application/json",
          success:function(data){
            if(data.msg==""){
              debugger
              showtable(data.data);
            }else {
              alert("error");
              window.location.reload();
            }
          }
        })
      })
})
//[{name: "算法", path: "/file", discription: "十分", type: "psf"}]
//$('#file')[0].files[0]
