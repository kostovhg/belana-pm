package com.belana.production.web.controllers;

import com.belana.production.repositories.ClientRepository;
import com.belana.production.services.ClientService;
import com.belana.production.services.ProductService;
import com.belana.production.utils.MapperUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)

public class RegisterOrderControllerTest {

//    private MockMvc mockMvc;
//    private RegisterOrderController registerOrderController;
//
//    @MockBean
//    private ClientRepository clientRepository;
//
//    @MockBean
//    private ClientService clientService;
//
//    @MockBean
//    private ProductService productService;
//
//
//    @Before
//    public void setup(){
//        MapperUtil mapperUtil = new MapperUtil();
//
//        registerOrderController = new RegisterOrderController(mapperUtil, clientService, productService);
//
//        mockMvc = MockMvcBuilders.standaloneSetup(registerOrderController).build();
//    }
//
//
//    @Test
//    public void testGetHome_byUnregisteredUser() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("register-order"));
//    }
//
//    @Test
//    public void testGetHome_ByRegisteredUser() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("register-order"));
//    }
}
