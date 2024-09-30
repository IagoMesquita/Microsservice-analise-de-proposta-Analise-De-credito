package com.iagomesquita.analisecredito.service.strategy.impl;

import com.iagomesquita.analisecredito.domain.Proposal;
import com.iagomesquita.analisecredito.service.strategy.PointsCalculation;
import org.springframework.stereotype.Component;

@Component
public class IncomeGreaterThanAmountRequested implements PointsCalculation {

  @Override
  public int calculate(Proposal proposal) {
    return isIncomeGreaterThanAmountRequested(proposal) ? 100 : 0;
  }

  private boolean isIncomeGreaterThanAmountRequested(Proposal proposal) {
    return proposal.getUsuario().getRenda() > proposal.getValorSolicitado();
  }
}
