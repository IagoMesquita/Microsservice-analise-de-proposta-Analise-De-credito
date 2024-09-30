package com.iagomesquita.analisecredito.service.strategy.impl;

import com.iagomesquita.analisecredito.domain.Proposal;
import com.iagomesquita.analisecredito.exceptions.StrategyException;
import com.iagomesquita.analisecredito.service.strategy.PointsCalculation;
import java.util.Random;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class NegativeNameImpl implements PointsCalculation {

  @Override
  public int calculate(Proposal proposal) {
    if (isNegativeName()) {
      throw new StrategyException("Nome negativo");
    }

    return 100;
  }

  private boolean isNegativeName() {
    return new Random().nextBoolean();
  }
}
