({
    init: function () {
        var me = this;
        me.page = 1;
        me.load = 1;
        me.event();
    },
    event: function () {
        var me = this;
        me.getList();
    },
    getList: function () { //圈子sns列表
        var me = this;
        var me = this;
        $.ajax({
            type: "post",
            url: "/api/feed/list",
            data: {
                pageNo: me.page,
                pageSize:5
            },
            async: true,
            success: function (res) {
                me.pageCount = res.body.sns.pagecount;
                var snsList = res.body.sns.list;
                $(".loading").hide();
                if(snsList.length!=0){
                    me.dealSnsListData(snsList);
                }
            }
        });
    },
    //去重
    dealSnsListData: function (snsList) {

        me.comListStr(res)
    },
    comListStr: function (list) {
        var me = this;

        me.page++;
        if( me.getCom == 1){
            $(window).scroll(function () {
                if($(document).height()-$(window).scrollTop()-window.screen.height<=200&&me.load == 1){
                    $(".loading").show();
                    me.getList();
                    me.load = 2;
                }
            });



        }

    },

    getParam:function (num) {
        var path =  location.pathname;
        path = path.substring(0,path.length-5);
        var arr = path.split('/');
        return arr[arr.length-num];
    },
    getUrlParms:function(name){
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)
            return unescape(r[2]);
        return null;
    }
}).init();