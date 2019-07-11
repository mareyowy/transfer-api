package com.marey.transferapi;

import com.marey.transferapi.account.repository.AccountRepository;
import com.marey.transferapi.account.repository.AccountRepositoryImpl;
import com.marey.transferapi.transfer.repository.TransferRepository;
import com.marey.transferapi.transfer.repository.TransferRepositoryImpl;
import com.marey.transferapi.transfer.service.TransferService;
import com.marey.transferapi.transfer.service.TransferServiceImpl;
import com.marey.transferapi.user.repository.UserRepository;
import com.marey.transferapi.user.repository.UserRepositoryImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class MainApplication extends ResourceConfig {


    public MainApplication() {
        packages("com.marey.transferapi");
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(AccountRepositoryImpl.class).to(AccountRepository.class);
                bind(TransferRepositoryImpl.class).to(TransferRepository.class);
                bind(UserRepositoryImpl.class).to(UserRepository.class);
                bind(TransferServiceImpl.class).to(TransferService.class);
            }
        });
        register(JacksonFeature.class);

    }
}
