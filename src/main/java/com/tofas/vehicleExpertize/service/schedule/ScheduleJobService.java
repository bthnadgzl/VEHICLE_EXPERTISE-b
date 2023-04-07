package com.tofas.vehicleExpertize.service.schedule;

import com.tofas.vehicleExpertize.model.dealerservice.DealerServiceResponse;
import com.tofas.vehicleExpertize.model.entity.Dealer;
import com.tofas.vehicleExpertize.model.dealerservice.config.DealerServiceApiCredentialInfo;
import com.tofas.vehicleExpertize.model.dealerservice.config.DealerServiceApiUrlInfo;
import com.tofas.vehicleExpertize.repository.DealerRepository;
import com.tofas.vehicleExpertize.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class ScheduleJobService {
    private final static String HEADER_TOKEN_KEY= "dealerServiceTokenKey";
    private final RestTemplate restTemplate;
    private final DealerServiceApiUrlInfo dealerServiceApiUrlInfo;
    private final DealerServiceApiCredentialInfo dealerServiceApiCredentialInfo;
    private final DealerRepository dealerRepository;
    private final Mapper mapper;
    @Scheduled(cron = "@monthly")
    public void scheduleTaskForGetDealerList() {
        ResponseEntity<DealerServiceResponse[]> responseEntityFiat;
        ResponseEntity<DealerServiceResponse[]> responseEntityArj;

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(dealerServiceApiCredentialInfo.getUsername(),dealerServiceApiCredentialInfo.getPassword());
        HttpEntity httpEntity = new HttpEntity<>(headers);

        responseEntityFiat = restTemplate.exchange(dealerServiceApiUrlInfo.getFiatUrl(), HttpMethod.GET, httpEntity, DealerServiceResponse[].class);
        responseEntityArj = restTemplate.exchange(dealerServiceApiUrlInfo.getArjUrl(), HttpMethod.GET, httpEntity, DealerServiceResponse[].class);
        DealerServiceResponse[] dealerServiceFiatResponses = responseEntityFiat.getBody();
        DealerServiceResponse[] dealerServiceArjResponses = responseEntityArj.getBody();

        for(int i = 0; i<dealerServiceFiatResponses.length; i++){
            Dealer dealer = mapper.mapSourceToTarget(dealerServiceFiatResponses[i],Dealer.class);
            dealerRepository.save(dealer);
        }
        for(int i = 0; i<dealerServiceArjResponses.length;i++){
            Dealer dealer = mapper.mapSourceToTarget(dealerServiceArjResponses[i],Dealer.class);
            dealerRepository.save(dealer);
        }
    }

}
