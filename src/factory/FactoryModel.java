package factory; /**
 * 工厂方法模式
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 创建工厂接口
 */
interface IMyMessageFactory{
    public IMyMessage createMessage(String messageType);
}

interface IMyMessage {
    public Map<String,Object> getMessageParam();
    public void setMessageParam(Map<String, Object> messageParam);
    public void sendMessage() throws Exception;   //发送通知
}

/**
 * 实现工厂
 */
class MessageFactory implements IMyMessageFactory {
    @Override
    public IMyMessage createMessage(String messageType) {
        // 这里的方式是：消费者知道自己想要什么产品；若生产何种产品完全由工厂决定，则这里不应该传入控制生产的参数。
        IMyMessage myMessage;
        Map<String,Object> messageParam =  new HashMap<String,Object>();

        if ("SMS".equals(messageType)) {
            myMessage = new MyMessageSms();
            messageParam.put("PHONENUM","123456");
        }else if ("OA".equals(messageType)) {
            myMessage = new MyMessageOaTodo();
            messageParam.put("OAUSERNAME","testUser");
        }else if ("EMAIL".equals(messageType)) {
            myMessage = new MyMessageEmail();
            messageParam.put("EMAIL","test@test.com");
        }else {
            myMessage = new MyMessageEmail();
            messageParam.put("EMAIL","test@test.com");
        }
        myMessage.setMessageParam(messageParam);

        return myMessage;
    }
}


abstract class MyAbstractMessage implements IMyMessage {
    private Map<String,Object> messageParam;

    @Override
    public Map<String, Object> getMessageParam() {
        return messageParam;
    }

    @Override
    public void setMessageParam(Map<String, Object> messageParam) {
        this.messageParam = messageParam;
    }
}

class MyMessageEmail extends MyAbstractMessage {
    @Override
    public void sendMessage() throws Exception {
        if (null == getMessageParam() || null == getMessageParam().get("EMAIL") || "".equals(getMessageParam().get("EMAIL"))) {
            throw new Exception("发送短信，需要传入EMAIL参数");
        }
        System.out.println("我是邮件，发通知给" + getMessageParam().get("EMAIL"));
    }
}

class MyMessageOaTodo extends MyAbstractMessage {
    @Override
    public void sendMessage() throws Exception {
        if (null == getMessageParam() || null == getMessageParam().get("OAUSERNAME") || "".equals(getMessageParam().get("OAUSERNAME"))) {
            throw new Exception("发送OA待办，需要传入OAUSERNAME参数");
        }
        System.out.println("我是OA待办，发送通知给" + getMessageParam().get("OAUSERNAME"));
    }
}

class MyMessageSms extends MyAbstractMessage {

    @Override
    public void sendMessage() throws Exception {
        // TODO Auto-generated method stub
        if (null == getMessageParam()
                || null == getMessageParam().get("PHONENUM")
                || "".equals(getMessageParam().get("PHONENUM"))) {
            throw new Exception("发送短信,需要传入PHONENUM参数");// 为了简单起见异常也不自定义了
        }// 另外短信信息，以及其他各种协议参数等等都要处理

        System.out.println("我是短信，发送通知给" + getMessageParam().get("PHONENUM"));
    }

}


public class FactoryModel{
    public static void main(String[] args) {
        MessageFactory messageFactory = new MessageFactory();
        IMyMessage myMessageSms;
        try {
            myMessageSms = messageFactory.createMessage("SMS");
            myMessageSms.sendMessage();

            myMessageSms = messageFactory.createMessage("EMAIL");
            myMessageSms.sendMessage();

            myMessageSms = messageFactory.createMessage("OA");
            myMessageSms.sendMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}