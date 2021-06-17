package com.stakater.ui.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@Route
@Slf4j
public class MainView extends VerticalLayout {

    @Value("${backend.base.url}")
    private String backUrl;

    public MainView() {

        HttpClient httpClient = HttpClient
            .newBuilder()
            .build();
        final TextArea textArea = new TextArea("Api response");
        textArea.setWidthFull();
        add(new Button("SAY HELLO", event -> {

            try {
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(backUrl + "/api/v1/greeting"))
                    .header("Accept", "text/html;charset=UTF-8")
                    .GET()
                    .build();
                String body = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
                    .body();
                textArea.setValue(LocalDateTime.now() + " " + body);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }));
        add(textArea);
    }


}
