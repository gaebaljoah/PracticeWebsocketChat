package hello.hellowebsocket.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    // connetction을 맺을때 CORS 허용
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //endpoint 지정 => 양 사용자 간 웹소켓 핸드셰이크를 위해 지정한다.
        registry.addEndpoint("/").setAllowedOrigins("*").withSockJS();
    }
}
