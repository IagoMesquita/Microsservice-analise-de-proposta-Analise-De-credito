package com.iagomesquita.analisecredito.service.strategy.impl;

import com.iagomesquita.analisecredito.domain.Proposal;
import com.iagomesquita.analisecredito.service.strategy.PointsCalculation;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class NegativeNameImpl implements PointsCalculation {

  @Override
  public int calculate(Proposal proposal) {
    if (isNegativeName()) {
      throw new RuntimeException("Nome negativo");
    }

    return 100;
  }

  private boolean isNegativeName() {
    return new Random().nextBoolean();
  }
}
