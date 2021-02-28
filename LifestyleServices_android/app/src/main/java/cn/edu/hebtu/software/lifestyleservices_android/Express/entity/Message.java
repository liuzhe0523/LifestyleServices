package cn.edu.hebtu.software.lifestyleservices_android.Express.entity;

//消息类
public class Message {

    //时间，格式为年-月-日 时:分:秒
    private String time;
    private String ftime;
    //详细信息内容
    private String context;
    private String loction;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    public String getLoction() {
        return loction;
    }

    public void setLoction(String loction) {
        this.loction = loction;
    }

    @Override
    public String toString() {
        return "Message{" +
                "time='" + time + '\'' +
                ", ftime='" + ftime + '\'' +
                ", context='" + context + '\'' +
                ", loction='" + loction + '\'' +
                '}';
    }
}
