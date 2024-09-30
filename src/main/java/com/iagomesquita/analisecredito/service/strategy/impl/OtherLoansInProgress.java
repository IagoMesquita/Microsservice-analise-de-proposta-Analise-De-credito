package com.iagomesquita.analisecredito.service.strategy.impl;

import com.iagomesquita.analisecredito.domain.Proposal;
import com.iagomesquita.analisecredito.service.strategy.PointsCalculation;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class OtherLoansInProgress implements PointsCalculation {

  @Override
  public int calculate(Proposal proposal) {
    return isOtherLoansInProgress() ? 0 : 80;
  }

  private boolean isOtherLoansInProgress() {
    return new Random().nextBoolean();
  }
}
