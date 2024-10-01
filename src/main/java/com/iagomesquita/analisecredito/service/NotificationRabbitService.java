package com.iagomesquita.analisecredito.service;

import com.iagomesquita.analisecredito.domain.Proposal;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificationRabbitService {

  private RabbitTemplate rabbitTemplate;

  public void notify(String exchange, Proposal proposal){
    rabbitTemplate.convertAndSend(exchange, "", proposal);
  }

}
