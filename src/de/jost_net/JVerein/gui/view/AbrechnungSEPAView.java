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

import java.text.MessageFormat;

import de.jost_net.JVerein.Einstellungen;
import de.jost_net.JVerein.gui.action.DokumentationAction;
import de.jost_net.JVerein.gui.control.AbrechnungSEPAControl;
import de.jost_net.JVerein.rmi.Konto;
import de.willuhn.datasource.rmi.DBIterator;
import de.willuhn.jameica.gui.AbstractView;
import de.willuhn.jameica.gui.Action;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.parts.ButtonArea;
import de.willuhn.jameica.gui.util.LabelGroup;
import de.willuhn.util.ApplicationException;

public class AbrechnungSEPAView extends AbstractView
{

  @Override
  public void bind() throws Exception
  {
    if (Einstellungen.getEinstellung().getName() == null
        || Einstellungen.getEinstellung().getName().length() == 0
        || Einstellungen.getEinstellung().getIban() == null
        || Einstellungen.getEinstellung().getIban().length() == 0)
    {
      throw new ApplicationException(
          "Name des Vereins oder Bankverbindung fehlt.Bitte unter Administration|Einstellungen erfassen.");
    }
    if (Einstellungen.getEinstellung().getGlaeubigerID() == null
        || Einstellungen.getEinstellung().getGlaeubigerID().length() == 0)
    {
      throw new ApplicationException(
          "Gl�ubiger-ID fehlt. Gfls. unter https://extranet.bundesbank.de/scp/ oder http://www.oenb.at/idakilz/cid?lang=de beantragen und unter Administration|Einstellungen|Allgemein eintragen.\n"
              + "Zu Testzwecken kann DE98ZZZ09999999999 eingesetzt werden.");
    }

    DBIterator it = Einstellungen.getDBService().createList(Konto.class);
    it.addFilter("nummer = ?", Einstellungen.getEinstellung().getKonto());
    if (it.size() != 1)
    {
      throw new ApplicationException(
          MessageFormat
              .format(
                  "Konto {0} ist in der Buchf�hrung nicht eingerichtet. Menu: Buchf�hrung | Konten",
                  Einstellungen.getEinstellung().getKonto()));
    }

    GUI.getView().setTitle("Abrechnung SEPA");

    final AbrechnungSEPAControl control = new AbrechnungSEPAControl(this);

    LabelGroup group = new LabelGroup(getParent(), "Parameter");
    group.addLabelPair("Modus", control.getAbbuchungsmodus());
    group.addLabelPair("F�lligkeit SEPA", control.getFaelligkeit());
    group.addLabelPair("Stichtag", control.getStichtag());
    group.addLabelPair("Von Eingabedatum", control.getVondatum());
    group
        .addLabelPair("Zahlungsgrund f�r Beitr�ge", control.getZahlungsgrund());
    group.addLabelPair("Zusatzbetr�ge", control.getZusatzbetrag());
    if (!Einstellungen.getEinstellung().getZusatzbetrag())
    {
      control.getZusatzbetrag().setEnabled(false);
    }
    group.addLabelPair("Kursteilnehmer", control.getKursteilnehmer());
    group.addLabelPair("Kompakte Abbuchung", control.getKompakteAbbuchung());
    group.addLabelPair("SEPA-Datei drucken", control.getSEPAPrint());

    if (!Einstellungen.getEinstellung().getKursteilnehmer())
    {
      control.getKursteilnehmer().setEnabled(false);
    }
    group.addLabelPair("Abbuchungsausgabe", control.getAbbuchungsausgabe());
    group.addSeparator();
    group
        .addText(
            "*) f�r die Berechnung, ob ein Mitglied bereits eingetreten oder ausgetreten ist. ",
            true);

    ButtonArea buttons = new ButtonArea();
    buttons.addButton("Hilfe", new DokumentationAction(),
        DokumentationUtil.ABRECHNUNG, false, "help-browser.png");
    buttons.addButton("Fehler/Warnungen/Hinweise", new Action()
    {
      @Override
      public void handleAction(Object context) throws ApplicationException
      {
        GUI.startView(SEPABugsView.class.getName(), null);
      }
    }, null, false, "debug_exc.gif");
    buttons.addButton(control.getStartButton());
    buttons.paint(this.getParent());
  }

  @Override
  public String getHelp()
  {
    return "<form><p><span color=\"header\" font=\"header\">Abbuchung</span> </p>"
        + "<p>Zun�chst ist der Modus auszuw�hlen. Die Auswahlm�glichkeiten "
        + "richten sich nach dem ausgew�hlten Beitragsmodell (siehe Einstellungen).</p>"
        + "<p>Der Stichtag wird  zur Pr�fung herangezogen, ob die Mitgliedschaft schon/noch besteht "
        + "und damit eine Abrechnung generiert muss. Liegt das Eintrittsdatum vor dem Stichtag und "
        + "das Austrittsdatum nach dem Stichtag, wird das Mitglied ber�cksichtigt.</p>"
        + "<p>Der angegebene Verwendungszweck wird bei allen Mitgliedsbeitrags-Buchungen "
        + "eingetragen. </p>"
        + "<p>  Es kann angegeben werden, ob Zusatzabbuchungen und Kursteilnehmer ber�cksichtigt "
        + " werden sollen.</p></form>";
  }
}