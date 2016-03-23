package br.icc.ddd.scrum.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.icc.ddd.scrum.domain.equipe.Membro;
import br.icc.ddd.scrum.domain.equipe.MembroRepository;

@FacesConverter("membroConverter")
public class MembroConverter implements Converter {

	@Inject
	private MembroRepository membroRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && value.trim().length() > 0) {
            try {
                return membroRepository.obter(Long.parseLong(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "erro de conversão", "Não é um membro válido"));
            }
        } else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj != null) {
            return String.valueOf(((Membro) obj).getId());
        } else {
            return null;
        }
	}
}
