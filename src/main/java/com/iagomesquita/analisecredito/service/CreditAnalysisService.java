package com.iagomesquita.analisecredito.service;

import com.iagomesquita.analisecredito.domain.Proposal;
import com.iagomesquita.analisecredito.exceptions.StrategyException;
import com.iagomesquita.analisecredito.service.strategy.PointsCalculation;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CreditAnalysisService {

  private final List<PointsCalculation> pointsCalculations;

  private NotificationRabbitService notificationRabbitService;

  @Value("${rabbitmq.exchange.proposalcompleted}")
  private String exchangeProposalCompleted;

  public CreditAnalysisService(List<PointsCalculation> pointsCalculation) {
    this.pointsCalculations = pointsCalculation;
  }

  public void toAnalyze(Proposal proposal) {
   try{
     int score = pointsCalculations.stream()
         .mapToInt(impl -> impl.calculate(proposal))
         .sum();

     int MINIMUM_SCORE = 350;
     boolean isApproved = score > MINIMUM_SCORE;

     proposal.setAprovada(isApproved);

   } catch (StrategyException exception) {

     proposal.setAprovada(false);
     proposal.setObservacao(exception.getMessage());

   }

   notificationRabbitService.notify(exchangeProposalCompleted, proposal);
  }

}

//Passando a interface como uma lista e usando a injection de dependency do Spring,
// O propria framework ira nos devolver uma lista com as implementations de PointsCalculation.
// Mas para que isso acontecia, e preciso passar annotates em cada implementacao da interface
// ficar aos cuidados do Spring.