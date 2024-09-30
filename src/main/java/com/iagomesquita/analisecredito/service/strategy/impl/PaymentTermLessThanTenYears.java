package com.iagomesquita.analisecredito.service.strategy.impl;

import com.iagomesquita.analisecredito.domain.Proposal;
import com.iagomesquita.analisecredito.service.strategy.PointsCalculation;
import org.springframework.stereotype.Component;

@Component
public class PaymentTermLessThanTenYears implements PointsCalculation {

  @Override
  public int calculate(Proposal proposal) {
    return proposal.getPrazoPagamento() < 120 ? 80 : 0;
  }
}
