package hello.hellowebsocket.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    // connetction을 맺을때 CORS 허용
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        System.out.println("registerStompEndpoints의 영역");
        //endpoint 지정 => 양 사용자 간 웹소켓 핸드셰이크를 위해 지정한다.
        registry.addEndpoint("/wsTest").setAllowedOrigins("*").withSockJS();
        System.out.println("registry.toString()..?"+registry.toString());
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
