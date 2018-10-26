<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href=".">
    <title>美少妇 - 海量图片任你看</title>
    <meta name="baidu-site-verification" content="UWl4tVX0j0" />
    <meta name="keywords" content="美少妇,美少妇空间,图片写真,美少妇,msf.zone,好图尽在美少妇,少妇,${categoryName!}">
    <meta name="description" content="美少妇海量图片展示,给你带来全新无广告的视觉盛宴."/>
    <link rel="icon" href="/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${staticUrl}css/index.css?v=${cssVersion}">
    <link rel="stylesheet" href="${staticUrl}css/category.css?v=${cssVersion}">
</head>
<body>
<header class="header">
    <div class="header_left">
        美少妇-海量好图任你看 www.msf.zone
    </div>
    <script>
        function IsPC() {
            var userAgentInfo = navigator.userAgent;
            var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
            var flag = true;
            for (var v = 0; v < Agents.length; v++) {
                if (userAgentInfo.indexOf(Agents[v]) > 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
        if (!IsPC()) {
            window.location.href = 'http://m.msf.zone';
        }
    </script>
</header>
<div class="body">
    <nav class="nav">
        <a class="logo-link" href="http://www.msf.zone/">
            <img class="logo" src="/images/logo.png" width="150">
        </a>
        <ul class="navList">
            <li><a href="/" <#if categoryId==0>class="nav-active"</#if>>首页</a></li>
            <li><a href="/news/" <#if categoryId==9>class="nav-active"</#if>>今日更新</a></li>
            <li><a href="/tuijian/" <#if categoryId==10>class="nav-active"</#if>>推荐</a></li>
            <li><a href="/wangqi/" <#if categoryId==11>class="nav-active"</#if>>往期</a></li>
        </ul>
    </nav>
    <div class="content">
        <div class="content-left">
            <ul class="content-list">
                <div class="authorlist mt12">
                    <#list mainLst as item>
                        <dl>
                            <a href="/thread?_sid=${item.id?c}" style="display: block;" target="_blank">
                                <dt>
                                <img src="${item.coverImgUrl}" alt="${item.title}" >
                                <p style="overflow-wrap: break-word;">${item.title}</p>
                                </dt>
                            </a>
                        </dl>
                    </#list>
                </div>
            </ul>
            <div class="loading">
                <img src="/images/loading.gif">
                <div>加载中...</div>
            </div>
        </div>
        <div class="content-right">
            <#--<div class="searchBox">-->
                <#--<form name="searchform" id="searchform" method="get">-->
                    <#--<input name="key" id="key" class="searchInput" type="text" placeholder="搜索......" value="">-->
                    <#--<button class="searchButton" onclick="search()">搜索</button>-->
                <#--</form>-->
            <#--</div>-->

            <div class="hot">
                <h3>热门</h3>
                <ul class="hot-video">
                    <#list hotLst as item>
                        <li>
                            <a href="/thread?_sid=${item.id?c}"  target="_blank">
                                <div class="hot-video-img">
                                    <img src="${item.coverImgUrl}" alt="${item.title}">
                                </div>
                                <div class="hot-video-title">
                                    <h4>${item.title}</h4>
                                    <p>${item.view_count}次浏览</p>
                                </div>
                            </a>
                        </li>
                    </#list>
                </ul>
            </div>
            <#--<div class="hot">-->
                <#--<h3>今日推荐</h3>-->
                <#--<ul class="new-list">-->

                    <#--<li>-->
                        <#--<a href="http://www.dalungu.com/page/SsdQamFw" target="_blank">-->
                            <#--<div class="hot-video-img">-->
                                <#--<img src="./dalungu_files/054101015BB35DACAD8C70C4C6604866" alt="" width="100%" height="100%">-->
                            <#--</div>-->
                            <#--<div class="hot-video-title">-->
                                <#--<h4>2018巴黎车展：广汽传祺全新GS5正式发布</h4>-->
                                <#--<p>29次播放<span>·</span>几次评论</p>-->
                            <#--</div>-->
                        <#--</a>-->
                    <#--</li>-->
                <#--</ul>-->
            <#--</div>-->
            <div class="copyright">
                <ul>
                    <li>© 2018 MSF 美少妇 www.msf.zone</li>
                    <li>部分图片来自网络，如有侵权，联系我们删除！</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script>
    var categoryId =${categoryId};
</script>
<script src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
<script src="${staticUrl}js/index.js?v=${jsVersion}"></script>
</body>
</html>