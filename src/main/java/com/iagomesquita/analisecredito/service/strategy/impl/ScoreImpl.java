package com.iagomesquita.analisecredito.service.strategy.impl;

import com.iagomesquita.analisecredito.domain.Proposal;
import com.iagomesquita.analisecredito.service.strategy.PointsCalculation;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class ScoreImpl implements PointsCalculation {

  @Override
  public int calculate(Proposal proposal) {
    int score = score();

    if (score <= 200) {
      throw new RuntimeException("Score baixo");
    } else if (score <= 400) {
      return 150;
    } else {
      return 200;
    }

  }

  // Simular pontos que viriam de uma api
  private int score() {
    return new Random().nextInt(0, 1000);
  }
}
