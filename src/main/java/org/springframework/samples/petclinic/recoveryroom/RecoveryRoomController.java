package org.springframework.samples.petclinic.recoveryroom;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
public class RecoveryRoomController {

    @Autowired
    RecoveryRoomService recoveryRoomService;


    private static final String VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

    @GetMapping(value = "/recoveryroom/create")
    public String initCreationForm(Map<String, Object> model) {
        RecoveryRoom recoveryRoom = new RecoveryRoom();
        model.put("recoveryRoom", recoveryRoom);
        model.put("types", this.recoveryRoomService.getAllRecoveryRoomTypes());
        return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/recoveryroom/create")
    public String initCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM;
        }
        else {
            //creating owner, user and authorities
            this.recoveryRoomService.save(recoveryRoom);
            return "welcome";
        }

    }
}
