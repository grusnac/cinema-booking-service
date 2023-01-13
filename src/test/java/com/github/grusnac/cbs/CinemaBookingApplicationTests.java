package com.github.grusnac.cbs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class CinemaBookingApplicationTests {

  @Autowired private WebApplicationContext context;

  private MockMvc mvc;

  @BeforeEach
  public void setup() {
    mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
  }

  @WithMockUser(username = "john.doe@mailcom", password = "secret")
  @Test
  public void shouldWorkGreat() throws Exception {
    mvc.perform(get("/films")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @WithMockUser(username = "joana.doe@mailcom", password = "secret")
  @Test
  public void shouldNotWorkGreat() throws Exception {
    mvc.perform(get("/films")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }
}
