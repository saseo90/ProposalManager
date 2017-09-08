package org.commons.util.connecter.service;

import java.io.IOException;

import org.commons.util.connecter.vo.DocumentVo;

public interface TongjeonConnection {
    /**
     * NCIS 홈페이지 클로킹
     * @return DocumentVo
     * @throws IOException
     */
    public DocumentVo connNcis() throws IOException;
    /**
     * NCIA 홈페이지 클로킹
     * @return DocumentVo
     * @throws IOException
     */
    public DocumentVo connNcia() throws IOException;
}
