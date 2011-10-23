/**********************************************************************
 * $Source$
 * $Revision$
 * $Date$
 * $Author$
 *
 * Copyright (c) by Heiner Jostkleigrewe
 * This program is free software: you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See 
 *  the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.  If not, 
 * see <http://www.gnu.org/licenses/>.
 * 
 * heiner@jverein.de
 * www.jverein.de
 **********************************************************************/
package de.jost_net.JVerein.gui.view;

import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.gui.action.DokumentationAction;
import de.jost_net.JVerein.gui.control.FormularControl;
import de.willuhn.jameica.gui.AbstractView;
import de.willuhn.jameica.gui.Action;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.util.ButtonArea;
import de.willuhn.jameica.gui.util.LabelGroup;

public class FormularDetailView extends AbstractView
{

  @Override
  public void bind() throws Exception
  {
    GUI.getView().setTitle(JVereinPlugin.getI18n().tr("Formular"));

    final FormularControl control = new FormularControl(this);

    LabelGroup group = new LabelGroup(getParent(), JVereinPlugin.getI18n().tr(
        "Formular"));
    group.addLabelPair(JVereinPlugin.getI18n().tr("Bezeichnung"),
        control.getBezeichnung(true));
    group.addLabelPair(JVereinPlugin.getI18n().tr("Art"), control.getArt());
    group.addLabelPair(JVereinPlugin.getI18n().tr("Datei"), control.getDatei());

    ButtonArea buttons = new ButtonArea(getParent(), 3);
    buttons.addButton(JVereinPlugin.getI18n().tr("Hilfe"),
        new DokumentationAction(), DokumentationUtil.FORMULARE, false,
        "help-browser.png");
    buttons.addButton(JVereinPlugin.getI18n().tr("speichern"), new Action()
    {

      public void handleAction(Object context)
      {
        control.handleStore();
      }
    }, null, true, "document-save.png");
  }

  @Override
  public String getHelp()
  {
    return "<form><p><span color=\"header\" font=\"header\">Formular</span></p>"
        + "<p>Jedem Formuar ist ein eindeutiger Name zu geben. Die Art ist auszuwählen. "
        + "Ein Dateiname ist bei der Neuaufnahme eines Formulares anzugeben oder wenn "
        + "das Formular aktualisiert wird. Das Formular muss im PDF-Format vorliegen.</p>"
        + "</form>";
  }
}
