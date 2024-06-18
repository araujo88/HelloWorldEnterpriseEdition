// Interface for any message
interface Message {
    String getMessage();
}

// Concrete implementation of a basic message
class HelloWorldMessage implements Message {
    private String message;

    private HelloWorldMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    // Singleton Pattern to ensure only one instance
    private static HelloWorldMessage instance = new HelloWorldMessage("Hello, World!");

    public static HelloWorldMessage getInstance() {
        return instance;
    }
}

// Interface for message delivery mechanism
interface MessageDelivery {
    void deliver(Message message);
}

// Implementation of message delivery via console
class ConsoleMessageDelivery implements MessageDelivery {
    public void deliver(Message message) {
        System.out.println(message.getMessage());
    }
}

// Factory for creating MessageDelivery objects
class MessageDeliveryFactory {
    public static MessageDelivery createMessageDelivery() {
        return new ConsoleMessageDelivery();
    }
}

// Main application class to run the program
public class HelloWorldApp {
    public static void main(String[] args) {
        // Factory Pattern to get the message delivery mechanism
        MessageDelivery delivery = MessageDeliveryFactory.createMessageDelivery();

        // Singleton Pattern to get the message instance
        Message message = HelloWorldMessage.getInstance();

        // Delivering the message
        delivery.deliver(message);
    }
}
