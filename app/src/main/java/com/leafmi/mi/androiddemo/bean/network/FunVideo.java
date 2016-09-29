package com.leafmi.mi.androiddemo.bean.network;

import java.util.List;

/**
 * Created by Admin on 2016/9/28.
 */
public class FunVideo {

    /**
     * error : false
     * results : [{"who":"zddhub","type":"搞笑视频","desc":"街头用现金买路人女朋友测试","url":"http://v.youku.com/v_show/id_XMTUzMTk0MTExNg==.html","publishedAt":"2016-04-14T08:55:52.896Z","createdAt":"2016-04-14T00:55:52.898Z","updatedAt":"2016-04-14T00:55:52.898Z","id":"570eea988b9ab20100f925d0"},
     * {"who":"zddhub","type":"搞笑视频","desc":"[papi酱]上海话讲英语第4弹","url":"http://v.youku.com/v_show/id_XMTUzMDIzNjA2MA==.html","publishedAt":"2016-04-13T00:50:29.849Z","createdAt":"2016-04-12T16:50:29.850Z","updatedAt":"2016-04-12T16:50:29.850Z","id":"570d27558b9ab20100f925c8"}]
     */

    private boolean error;
    /**
     * who : zddhub
     * type : 搞笑视频
     * desc : 街头用现金买路人女朋友测试
     * url : http://v.youku.com/v_show/id_XMTUzMTk0MTExNg==.html
     * publishedAt : 2016-04-14T08:55:52.896Z
     * createdAt : 2016-04-14T00:55:52.898Z
     * updatedAt : 2016-04-14T00:55:52.898Z
     * id : 570eea988b9ab20100f925d0
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String who;
        private String type;
        private String desc;
        private String url;
        private String publishedAt;
        private String createdAt;
        private String updatedAt;
        private String id;

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
