package com.yangdxg.baselib;

import java.util.List;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/26.
 * 功能：
 */

public class Move {

    /**
     * count : 10
     * start : 0
     * total : 250
     * subjects : [{"rating":{"max":10,"average":9.6,"stars":"50","min":0},"genres":["犯罪","剧情"],"title":"肖申克的救赎","casts":[{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp"},"name":"蒂姆·罗宾斯","id":"1054521"},{"alt":"https://movie.douban.com/celebrity/1054534/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.webp"},"name":"摩根·弗里曼","id":"1054534"},{"alt":"https://movie.douban.com/celebrity/1041179/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.webp"},"name":"鲍勃·冈顿","id":"1041179"}],"collect_count":1694853,"original_title":"The Shawshank Redemption","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1047973/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp"},"name":"弗兰克·德拉邦特","id":"1047973"}],"year":"1994","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp"},"alt":"https://movie.douban.com/subject/1292052/","id":"1292052"},{"rating":{"max":10,"average":9.6,"stars":"50","min":0},"genres":["剧情","爱情","同性"],"title":"霸王别姬","casts":[{"alt":"https://movie.douban.com/celebrity/1003494/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp"},"name":"张国荣","id":"1003494"},{"alt":"https://movie.douban.com/celebrity/1050265/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp"},"name":"张丰毅","id":"1050265"},{"alt":"https://movie.douban.com/celebrity/1035641/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp"},"name":"巩俐","id":"1035641"}],"collect_count":1364603,"original_title":"霸王别姬","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1023040/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451727734.81.webp"},"name":"陈凯歌","id":"1023040"}],"year":"1993","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp"},"alt":"https://movie.douban.com/subject/1291546/","id":"1291546"},{"rating":{"max":10,"average":9.4,"stars":"50","min":0},"genres":["剧情","动作","犯罪"],"title":"这个杀手不太冷","casts":[{"alt":"https://movie.douban.com/celebrity/1025182/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p8833.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p8833.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p8833.webp"},"name":"让·雷诺","id":"1025182"},{"alt":"https://movie.douban.com/celebrity/1054454/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2274.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2274.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2274.webp"},"name":"娜塔莉·波特曼","id":"1054454"},{"alt":"https://movie.douban.com/celebrity/1010507/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33896.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33896.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33896.webp"},"name":"加里·奥德曼","id":"1010507"}],"collect_count":1773007,"original_title":"Léon","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1031876/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33301.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33301.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33301.webp"},"name":"吕克·贝松","id":"1031876"}],"year":"1994","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p511118051.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p511118051.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p511118051.webp"},"alt":"https://movie.douban.com/subject/1295644/","id":"1295644"},{"rating":{"max":10,"average":9.4,"stars":"50","min":0},"genres":["剧情","爱情"],"title":"阿甘正传","casts":[{"alt":"https://movie.douban.com/celebrity/1054450/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p28603.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p28603.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p28603.webp"},"name":"汤姆·汉克斯","id":"1054450"},{"alt":"https://movie.douban.com/celebrity/1002676/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1537890386.77.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1537890386.77.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1537890386.77.webp"},"name":"罗宾·怀特","id":"1002676"},{"alt":"https://movie.douban.com/celebrity/1031848/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1345.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1345.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1345.webp"},"name":"加里·西尼斯","id":"1031848"}],"collect_count":1497347,"original_title":"Forrest Gump","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1053564/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p505.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p505.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p505.webp"},"name":"罗伯特·泽米吉斯","id":"1053564"}],"year":"1994","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p510876377.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p510876377.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p510876377.webp"},"alt":"https://movie.douban.com/subject/1292720/","id":"1292720"},{"rating":{"max":10,"average":9.5,"stars":"50","min":0},"genres":["剧情","喜剧","爱情"],"title":"美丽人生","casts":[{"alt":"https://movie.douban.com/celebrity/1041004/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p26764.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p26764.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p26764.webp"},"name":"罗伯托·贝尼尼","id":"1041004"},{"alt":"https://movie.douban.com/celebrity/1000375/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9548.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9548.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9548.webp"},"name":"尼可莱塔·布拉斯基","id":"1000375"},{"alt":"https://movie.douban.com/celebrity/1000368/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45590.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45590.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45590.webp"},"name":"乔治·坎塔里尼","id":"1000368"}],"collect_count":781403,"original_title":"La vita è bella","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1041004/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p26764.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p26764.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p26764.webp"},"name":"罗伯托·贝尼尼","id":"1041004"}],"year":"1997","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p510861873.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p510861873.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p510861873.webp"},"alt":"https://movie.douban.com/subject/1292063/","id":"1292063"},{"rating":{"max":10,"average":9.3,"stars":"50","min":0},"genres":["剧情","爱情","灾难"],"title":"泰坦尼克号","casts":[{"alt":"https://movie.douban.com/celebrity/1041029/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p814.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p814.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p814.webp"},"name":"莱昂纳多·迪卡普里奥","id":"1041029"},{"alt":"https://movie.douban.com/celebrity/1054446/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53358.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53358.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53358.webp"},"name":"凯特·温丝莱特","id":"1054446"},{"alt":"https://movie.douban.com/celebrity/1031864/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45186.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45186.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45186.webp"},"name":"比利·赞恩","id":"1031864"}],"collect_count":1378802,"original_title":"Titanic","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1022571/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33715.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33715.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33715.webp"},"name":"詹姆斯·卡梅隆","id":"1022571"}],"year":"1997","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p457760035.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p457760035.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p457760035.webp"},"alt":"https://movie.douban.com/subject/1292722/","id":"1292722"},{"rating":{"max":10,"average":9.3,"stars":"50","min":0},"genres":["剧情","动画","奇幻"],"title":"千与千寻","casts":[{"alt":"https://movie.douban.com/celebrity/1023337/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1463193210.13.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1463193210.13.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1463193210.13.webp"},"name":"柊瑠美","id":"1023337"},{"alt":"https://movie.douban.com/celebrity/1005438/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44986.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44986.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44986.webp"},"name":"入野自由","id":"1005438"},{"alt":"https://movie.douban.com/celebrity/1045797/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1376151005.51.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1376151005.51.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1376151005.51.webp"},"name":"夏木真理","id":"1045797"}],"collect_count":1267620,"original_title":"千と千尋の神隠し","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1054439/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p616.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p616.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p616.webp"},"name":"宫崎骏","id":"1054439"}],"year":"2001","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1606727862.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1606727862.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1606727862.webp"},"alt":"https://movie.douban.com/subject/1291561/","id":"1291561"},{"rating":{"max":10,"average":9.5,"stars":"50","min":0},"genres":["剧情","历史","战争"],"title":"辛德勒的名单","casts":[{"alt":"https://movie.douban.com/celebrity/1031220/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44906.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44906.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44906.webp"},"name":"连姆·尼森","id":"1031220"},{"alt":"https://movie.douban.com/celebrity/1054393/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1374649659.58.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1374649659.58.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1374649659.58.webp"},"name":"本·金斯利","id":"1054393"},{"alt":"https://movie.douban.com/celebrity/1006956/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p28941.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p28941.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p28941.webp"},"name":"拉尔夫·费因斯","id":"1006956"}],"collect_count":727577,"original_title":"Schindler's List","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1054440/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp"},"name":"史蒂文·斯皮尔伯格","id":"1054440"}],"year":"1993","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p492406163.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p492406163.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p492406163.webp"},"alt":"https://movie.douban.com/subject/1295124/","id":"1295124"},{"rating":{"max":10,"average":9.3,"stars":"50","min":0},"genres":["剧情","科幻","悬疑"],"title":"盗梦空间","casts":[{"alt":"https://movie.douban.com/celebrity/1041029/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p814.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p814.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p814.webp"},"name":"莱昂纳多·迪卡普里奥","id":"1041029"},{"alt":"https://movie.douban.com/celebrity/1101703/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3517.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3517.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3517.webp"},"name":"约瑟夫·高登-莱维特","id":"1101703"},{"alt":"https://movie.douban.com/celebrity/1012520/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p118.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p118.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p118.webp"},"name":"艾伦·佩吉","id":"1012520"}],"collect_count":1499807,"original_title":"Inception","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1054524/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p673.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p673.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p673.webp"},"name":"克里斯托弗·诺兰","id":"1054524"}],"year":"2010","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p513344864.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p513344864.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p513344864.webp"},"alt":"https://movie.douban.com/subject/3541415/","id":"3541415"},{"rating":{"max":10,"average":9.3,"stars":"50","min":0},"genres":["剧情"],"title":"忠犬八公的故事","casts":[{"alt":"https://movie.douban.com/celebrity/1040997/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33013.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33013.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33013.webp"},"name":"理查·基尔","id":"1040997"},{"alt":"https://movie.douban.com/celebrity/1049499/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5502.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5502.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5502.webp"},"name":"萨拉·罗默尔","id":"1049499"},{"alt":"https://movie.douban.com/celebrity/1025215/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17520.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17520.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17520.webp"},"name":"琼·艾伦","id":"1025215"}],"collect_count":1087972,"original_title":"Hachi: A Dog's Tale","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1018014/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4333.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4333.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4333.webp"},"name":"拉斯·霍尔斯道姆","id":"1018014"}],"year":"2009","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p524964016.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p524964016.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p524964016.webp"},"alt":"https://movie.douban.com/subject/3011091/","id":"3011091"}]
     * title : 豆瓣电影Top250
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":9.6,"stars":"50","min":0}
         * genres : ["犯罪","剧情"]
         * title : 肖申克的救赎
         * casts : [{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp"},"name":"蒂姆·罗宾斯","id":"1054521"},{"alt":"https://movie.douban.com/celebrity/1054534/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.webp"},"name":"摩根·弗里曼","id":"1054534"},{"alt":"https://movie.douban.com/celebrity/1041179/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.webp"},"name":"鲍勃·冈顿","id":"1041179"}]
         * collect_count : 1694853
         * original_title : The Shawshank Redemption
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1047973/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp"},"name":"弗兰克·德拉邦特","id":"1047973"}]
         * year : 1994
         * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp"}
         * alt : https://movie.douban.com/subject/1292052/
         * id : 1292052
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 9.6
             * stars : 50
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp
             * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp
             * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1054521/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp"}
             * name : 蒂姆·罗宾斯
             * id : 1054521
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        @Override
        public String toString() {
            return "SubjectsBean{" +
                    "rating=" + rating +
                    ", title='" + title + '\'' +
                    ", collect_count=" + collect_count +
                    ", original_title='" + original_title + '\'' +
                    ", subtype='" + subtype + '\'' +
                    ", year='" + year + '\'' +
                    ", images=" + images +
                    ", alt='" + alt + '\'' +
                    ", id='" + id + '\'' +
                    ", genres=" + genres +
                    ", casts=" + casts +
                    ", directors=" + directors +
                    '}';
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1047973/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp"}
             * name : 弗兰克·德拉邦特
             * id : 1047973
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "DirectorsBean{" +
                        "alt='" + alt + '\'' +
                        ", avatars=" + avatars +
                        ", name='" + name + '\'' +
                        ", id='" + id + '\'' +
                        '}';
            }

            public static class AvatarsBeanX {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                @Override
                public String toString() {
                    return "AvatarsBeanX{" +
                            "small='" + small + '\'' +
                            ", large='" + large + '\'' +
                            ", medium='" + medium + '\'' +
                            '}';
                }
            }
        }
    }
}
