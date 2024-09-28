package com.iagomesquita.analisecredito.listener;

import com.iagomesquita.analisecredito.domain.Proposal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PendingProposalListener {

  @RabbitListener(queues = "${rabbitmq.queue.pending-proposal.ms-analisecredito}")
  public void pendingProposal(Proposal proposal) {

  }

}
