package com.iagomesquita.analisecredito.service.strategy;

import com.iagomesquita.analisecredito.domain.Proposal;

public interface PointsCalculation {
  int calculate(Proposal proposal);
}
