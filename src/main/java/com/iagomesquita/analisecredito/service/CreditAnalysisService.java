package com.iagomesquita.analisecredito.service;

import com.iagomesquita.analisecredito.service.strategy.PointsCalculation;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CreditAnalysisService {

  private List<PointsCalculation> pointsCalculations;

  public CreditAnalysisService(List<PointsCalculation> pointsCalculation) {
    this.pointsCalculations = pointsCalculation;
  }

  public void toAnalyze() {}

}

//Passando a interface como uma lista e usando a injection de dependency do Spring,
// O propria framework ira nos devolver uma lista com as implementations de PointsCalculation.
// Mas para que isso acontecia, e preciso passar annotates em cada implementacao da interface
// ficar aos cuidados do Spring.