/**********************************************************************
 * $Source$
 * $Revision$
 * $Date$
 * $Author$
 *
 * Copyright (c) by Heiner Jostkleigrewe
 * All rights reserved
 * heiner@jverein.de
 * www.jverein.de
 * $Log$
 **********************************************************************/
package de.jost_net.JVerein.gui.view;

import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.gui.action.DokumentationAction;
import de.jost_net.JVerein.gui.action.MitgliedDetailAction;
import de.jost_net.JVerein.gui.control.MitgliedskontoControl;
import de.willuhn.jameica.gui.AbstractView;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.internal.buttons.Back;
import de.willuhn.jameica.gui.util.ButtonArea;
import de.willuhn.jameica.gui.util.LabelGroup;
import de.willuhn.util.ApplicationException;

public class MitgliedskontoListeView extends AbstractView
{
  public void bind() throws Exception
  {
    GUI.getView().setTitle("Mitgliedskonten");

    final MitgliedskontoControl control = new MitgliedskontoControl(this);
    LabelGroup group = new LabelGroup(getParent(), JVereinPlugin.getI18n().tr(
        "Filter"));
    group.addInput(control.getSuchName());
    group.addLabelPair("von", control.getVondatum());
    group.addLabelPair("bis", control.getBisdatum());
    group.addLabelPair("Differenz", control.getDifferenz());

    control.getMitgliedskontoList(new MitgliedDetailAction(), null).paint(
        this.getParent());

    ButtonArea buttons2 = new ButtonArea(this.getParent(), 3);
    buttons2.addButton(new Back(false));
    buttons2.addButton(JVereinPlugin.getI18n().tr("Hilfe"),
        new DokumentationAction(), DokumentationUtil.MITGLIEDSKONTO_UEBERSICHT,
        false, "help-browser.png");
  }

  public void unbind() throws ApplicationException
  {
  }

}
