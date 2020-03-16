import io.nuclio.Context;
import io.nuclio.Event;
import io.nuclio.EventHandler;
import io.nuclio.Response;
import net.openhft.hashing.LongHashFunction;
import org.apache.kafka.common.TopicPartition;

public class myHandler implements EventHandler {

    @Override
    public Response handleEvent(Context context, Event event) {
        TopicPartition t = new TopicPartition("tal", 15);
        String eventstr = new String(event.getBody());
        long hash = LongHashFunction.xx().hashChars(eventstr);
        return new Response().setBody("this is the hash of the text: " + hash + "  something - " + t.toString());
    }
}