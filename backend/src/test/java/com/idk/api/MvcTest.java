package com.idk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idk.api.config.WebMvcConfig;
import com.idk.api.user.security.token.JwtAuthEntryPoint;
import com.idk.api.user.security.token.JwtProps;
import com.idk.api.user.security.token.TokenProvider;
import com.idk.api.user.security.userdetails.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureRestDocs(uriScheme = "https", uriHost = "j7a208.p.ssafy.io", uriPort = 443)
@Import({
        WebMvcConfig.class,
        TokenProvider.class,
        JwtProps.class,
        RestDocsConfig.class,
})
@WithMockCustomUser
public abstract class MvcTest {
    @Autowired
    protected MockMvc mvc;
    @Autowired
    protected ObjectMapper objectMapper;
    @MockBean
    protected CustomUserDetailService customUserDetailService;
    @MockBean
    protected JwtAuthEntryPoint jwtAuthEntryPoint;
}
