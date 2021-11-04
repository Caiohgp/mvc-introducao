package br.com.caiohenriquedev.conversor;

import br.com.caiohenriquedev.domain.TipoSexo;
import org.springframework.core.convert.converter.Converter;

public class TipoSexoConverter implements Converter<String, TipoSexo> {
    @Override
    public TipoSexo convert(String s) {
        char tipo = s.charAt(0);
        return tipo == TipoSexo.FEMININO.getDescricao() ? TipoSexo.FEMININO : TipoSexo.MASCULINO;
    }
}
