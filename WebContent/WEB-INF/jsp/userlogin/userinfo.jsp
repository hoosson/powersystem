<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
<title>Power-System-用户信息</title>
	<!-- <link rel="stylesheet" type="text/css" href="css/register.css"/> -->
<style type="text/css">
#main {
    padding-top: 0;
    padding-bottom: 50px;
}
#main {
    min-height: 750px;
    padding: 20px 0;
}

.setting {
    background-color: #fff;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,.1);
    height: 900px;
    margin: -40px auto auto;
    overflow: hidden;
    width: 960px;
    margin: auto;
    position: relative;
}
.nav-tabs{
	width: 488px;
	height: 70px;
	margin-left: 32px;
}
.pa {
    position: absolute;
}
.pr {
    position: relative;
}
.ml20 {
    margin-left: 20px!important;
}
.pb10 {
    padding-bottom: 10px!important;
}
:link, :visited, ins {
    text-decoration: none;
}
.setting .active {
    color: #f01414!important;
    border-bottom: 2px solid #f01414;
}
.setting .baseinfo, .page-settings .setting .countinfo {
    font-size: 16px;
    color: #4d555d;
    height: 58px;
    margin-top: 10px;
    line-height: 58px;
    margin-right: 50px;
    z-index: 5;
}
.fl {
    float: left;
}
.contentBox {
    width: 896px;
    margin: 0px 32px;
    border-top: 1px solid #b7bbbf;
    position: relative;
    top: 69px;
    padding-top: 28px;
}
.setting .contentBox .formBox {
    width: 520px;
    margin: auto;
}
.setting-profile {
    width: 490px;
    margin-left: auto;
    margin-right: auto;
    background-color: #fff;
}
.label-name {
    float: left;
    width: 70px;
    text-align: right;
    height: 40px;
    line-height: 40px;
    color: #07111b;
    font-weight: 700;
    font-size: 14px;
}
.rlf-group {
    float: left;
    width: 410px;
    margin-left: 8px;
    color: #60686b;
}
.ptop130{
	padding-top: 130px;
}
.h230{
	height:230px;
}
.avator-btn-fake {
    display: block;
    width: 134px;
    height: 36px;
    line-height: 36px;
    color: #4d555d;
    vertical-align: middle;
    margin: 10px 0;
    text-align: center;
    cursor: pointer;
    /* position: absolute; */
    bottom: -20px;
    background-color: #fff!important;
    border: 1px solid #ccc;
}
.avator-btn-fake:hover {
	background-color: #f3f5f7!important
}
.hide {
    display: none;
}
.moco-form-control {
    display: block;
    width: 100%;
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #787d82;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 2px;
    box-sizing: border-box;
}
.rlf-tip-wrap {
    height: 24px!important;
    line-height: 24px!important;
}

.errorHint {
    height: 25px;
    line-height: 20px;
    font-size: 12px;
    color: #f01414;
}
.color-red {
    color: #EF1300!important;
}
.wlfg-wrap .label-name {
    float: left;
    width: 70px;
    text-align: right;
    height: 40px;
    line-height: 40px;
    color: #07111b;
    font-weight: 700;
    font-size: 14px;
}
.wlfg-wrap .rlf-group {
    float: left;
    width: 410px;
    margin-left: 8px;
    color: #60686b;
}
.profile-address {
	height: 64px;
}
.wlfg-wrap .profile-address select {
    float: left;
    margin-right: 10px;
    width: 130px;
    height: 40px;
}
.wlfg-wrap .profile-address select {
    float: left;
    margin-right: 10px;
    width: 130px;
    height: 40px;
}
.wlfg-wrap .profile-address .mr0 {
    margin-right: 0;
}
.wlfg-wrap .profile-address select {
    float: left;
    margin-right: 10px;
    width: 130px;
    height: 40px;
}
.wlfg-wrap .rlf-radio-group {
    max-width: 402px;
    padding-left: 10px;
}
.wlfg-wrap .rlf-radio-group input[type=radio] {
    margin-right: 10px;
}
.lh16 {
    line-height: 16px!important;
}
.wlfg-wrap .rlf-btn-green {
    background-color: #00b33b;
    border-radius: 2px;
}
.wlfg-wrap .profile-btn {
    display: block;
    color: #fff;
    text-align: center;
    line-height: 40px;
    cursor: pointer;
    width: 96px;
    height: 40px;
}
.wlfg-wrap .rlf-btn-green {
	background-color: #00b33b;
	border-radius: 2px
}
.wlfg-wrap .rlf-btn-green:hover {
	background-color: #33a646
}
</style>
	<script type="text/javascript">
	
	</script>
</head>
<body>
	<div id="main">
        
        <div class="setting pb10">
            <div class="nav-tabs pa">
                <h class="baseinfo fl active">基本信息</h>
                <div class="cb"></div>
            </div>
            <div class="contentBox">
                <div class="formBox">
                    <div id="setting-profile" class="setting-wrap setting-profile">

                        <div class="wlfg-wrap clearfix h230">
                            <label class="label-name" for="job">头像：</label>
                            <div class="rlf-group">
                                <img class="fl avator-img" id="js-portrait" src="images/head.jpg" data-portrait="头像" width="180" height="180">
                                <div class="fl ml20 pr ptop130">
                                    <div id="avator-btns" class="avator-btn-inner">
                                        <div class="avator-btn-wrap">
                                            <form target="uploadtarget" action="postpic" method="post" enctype="multipart/form-data">
                                                <a href="javascript:void(0)" hidefocus="true" class="avator-btn-fake">上传头像</a>
                                                <input class="hide" type="file" title="上传头像" name="fileField" id="upload" accept="image/*">
                                                <input class="hide" type="hidden" name="type" value="1">
                                            </form>
                                            <iframe src="about:blank" id="uploadtarget" name="uploadtarget" frameborder="0" style="display:none;"></iframe>
                                        </div>
                                    </div>
                                </div>
                                <div class="cb"></div>
                                <p class="rlf-tip-wrap errorHint color-red" ></p>
                            </div>
                        </div>

                        <form id="profile" >
                            <div class="wlfg-wrap clearfix">
                                <label class="label-name" for="nick" >昵称：</label>
                                <div class="rlf-group">
                                    <input type="text" name="nickname" id="nick"  autocomplete="off"  data-validate="require-nick"  class="moco-form-control" value="Sequin_YF" placeholder="请输入昵称."/>
                                    <p class="rlf-tip-wrap errorHint color-red" ></p>
                                </div>
                            </div>

                            <div class="wlfg-wrap clearfix">
                                <label class="label-name" for="province-select">城市：</label>
                                <div class="rlf-group profile-address">
                                    <select id="province-select" class='moco-form-control' hidefocus="true">
                                        <option value="0">选择省份</option>
                                        <option value="1">北京</option>
                                        <option value="2">天津</option>
                                        <option value="3">河北</option>
                                        <option value="4">山西</option>
                                        <option value="5">内蒙古</option>
                                        <option value="6">辽宁</option>
                                        <option value="7">吉林</option>
                                        <option value="8">黑龙江</option>
                                        <option value="9">上海</option>
                                        <option value="10">江苏</option>
                                        <option value="11">浙江</option>
                                        <option value="12">安徽</option>
                                        <option value="13">福建</option>
                                        <option value="14">江西</option>
                                        <option value="15">山东</option>
                                        <option value="16">河南</option>
                                        <option value="17">湖北</option>
                                        <option value="18">湖南</option>
                                        <option value="19">广东</option>
                                        <option value="20">海南</option>
                                        <option value="21">广西</option>
                                        <option value="22">甘肃</option>
                                        <option value="23">陕西</option>
                                        <option value="24">新疆</option>
                                        <option value="25">青海</option>
                                        <option value="26">宁夏</option>
                                        <option value="27">重庆</option>
                                        <option value="28">四川</option>
                                        <option value="29">贵州</option>
                                        <option value="30">云南</option>
                                        <option value="31">西藏</option>
                                        <option value="32">台湾</option>
                                        <option value="33">澳门</option>
                                        <option value="34">香港</option>
                                        <option value="100">其他</option>
                                    </select>
                                    <select class='moco-form-control' id="city-select" hidefocus="true">
                                        <option value="0">选择城市</option>
                                    </select>
                                    <select class='moco-form-control mr0' id="area-select" hidefocus="true">
                                        <option value="0">选择区县</option>
                                    </select>
                                    <div class="cb"></div>
                                    <p class="rlf-tip-wrap errorHint color-red"></p>
                                </div>
                            </div>

                            <div class="wlfg-wrap clearfix">
                                <label class="label-name h16 lh16" >性别：</label>
                                <div class="rlf-group rlf-radio-group">
                                    <label  class="lh16"><input type="radio" hidefocus="true" value="0"   name="sex">保密</label>
                                    <label  class="lh16"><input type="radio" hidefocus="true" value="1"  name="sex">男</label>
                                    <label  class="lh16"><input type="radio" hidefocus="true" value="2" checked="checked" name="sex">女</label>
                                    <p class="rlf-tip-wrap errorHint color-red"></p>
                                </div>
                            </div>
                            <div class="wlfg-wrap clearfix">
                                <label class="label-name" for="aboutme">个性签名：</label>
                                <div class="rlf-group">
                                    <div class="pr">
                                        <textarea name="aboutme"  id="aboutme"  rows="5" class="noresize js-sign moco-form-control"></textarea>
                                        <p class="numCanInput js-numCanInput ">还可以输入128个字符</p>
                                    </div>
                                </div>
                            </div>

                            <div class="wlfg-wrap clearfix">
                                <label class="label-name" for="profile-submit"></label>
                                <div class="rlf-group">
                                    <span id="profile-submit"  hidefocus="true"  aria-role="button" class="rlf-btn-green btn-block profile-btn">保存</span>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>

</div>
</body>
<!-- 使用jquery时必须导入jquery的包也就是js文件，这里使用jquery-1.8.3.min.js -->
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

</script>
</html>