package de.rwth.informatik.vorkurs.slackbot;

import com.slack.api.app_backend.events.payload.EventsApiPayload;
import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.bolt.context.builtin.EventContext;
import com.slack.api.bolt.response.Response;
import com.slack.api.bolt.socket_mode.SocketModeApp;
import com.slack.api.methods.SlackApiException;
import com.slack.api.model.event.AppMentionEvent;
import com.slack.api.model.event.MessageEvent;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        // Configure connecition via WebSocket
        App app = new App(AppConfig.builder().singleTeamBotToken(Configuration.BOT_TOKEN).build());
        SocketModeApp socketModeApp = new SocketModeApp(Configuration.APP_TOKEN, app);

        app.event(MessageEvent.class, Main::messageReceived);
        app.event(AppMentionEvent.class, Main::mentioned);
        socketModeApp.start();
    }

    private static Response mentioned(EventsApiPayload<AppMentionEvent> payload, EventContext eventContext) throws SlackApiException, IOException {
        var message = eventContext.say(payload.getEvent().getText());
        if (payload.getEvent().getBotId() != null) {
            return eventContext.ack();
        }
        if (!message.isOk()) {
            eventContext.logger.error("chat.postMessage failed: {}", message.getError());
        }
        return eventContext.ack();
    }

    private static Response messageReceived(EventsApiPayload<MessageEvent> payload, EventContext eventContext) throws SlackApiException, IOException {
        var message = eventContext.say(payload.getEvent().getText());
        if (payload.getEvent().getBotId() != null) {
            return eventContext.ack();
        }
        if (!message.isOk()) {
            eventContext.logger.error("chat.postMessage failed: {}", message.getError());
        }
        return eventContext.ack();
    }
}
