({
    init: function () {
        var me = this;
        me.p = 1;
        me.s = 9;
        me.isLoading = false;
        me.hasMore = true;
        me.event();
    },
    event: function () {
        var me = this;
        me.getList();
        $(window).scroll(function () {
            var totalheight = parseFloat($(window).height()) + parseFloat($(window).scrollTop());
            if (($(document).height() - 30) <= totalheight) {
                if (me.hasMore && !me.isLoading) {
                    window.console.log("ajax..");
                    me.getList();
                }
            }
        });
    },
    getList: function () { 
        var me = this;
        $.ajax({
            type: "get",
            url: "/api/feed/list",
            data: {
                p: me.p,
                s: me.s,
                c: categoryId
            },
            cache:false,
            beforeSend:function () {
                me.isLoading = true;
                $(".loading").show()
            },
            success: function (data) {
                if (data.code == 0) {
                    me.bindData(data.obj);
                } else {
                    me.hasMore = false;
                }
            },
            complete: function () {
                me.isLoading = false;

            }
        });
    },
    bindData: function (lst) {
        var me = this;
        if (lst.length>0) {
            var lsthtml="";
            $.each(lst, function (i, item) {
                lsthtml += "<dl>";
                lsthtml += "<a href=\"/thread?_sid=" + item.id + "\" style=\"display: block;\" target=\"_blank\">";
                lsthtml += "<dt>";
                lsthtml += "<img src=\"" + item.coverImgUrl + "\">";
                lsthtml += "<p style=\"overflow-wrap: break-word;\">" + item.title + "</p>";
                lsthtml += "</dt>"
                lsthtml += "</a>";
                lsthtml += "</dl>"
            });
            $(".mt12").append(lsthtml);
            $(".loading").hide();
        }
        if (lst.length < me.s) {
            me.hasMore = false;
        }
        $(".loading").hide();
        me.p++;
    }
}).init();