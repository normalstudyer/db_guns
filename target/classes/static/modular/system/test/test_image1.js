/**
 * Created by Administrator on 2018/12/14.
 */
$(function(){
    //提交图片剪切信息到后台
    $("#ensure").click(function(){

        var img64 = $(".preview-lg img").attr("src");
        // alert(x1+":"+y1+":"+x2+":"+y2);
        var url = "/guns/test/uploadImage1";
        var param = {
            'image': img64
        }
        console.log(param);
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            data:param,
            success:function (data) {
                Feng.success("上传成功!");;
            },
            error:function () {
                
            }
        });
        /*$.post(url,param,function(data){
            Feng.success("上传成功!");;
        });*/
    })

})