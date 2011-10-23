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
package de.jost_net.JVerein.gui.action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.rmi.AbstractDokument;
import de.willuhn.jameica.gui.Action;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.internal.action.Program;
import de.willuhn.jameica.messaging.QueryMessage;
import de.willuhn.jameica.messaging.StatusBarMessage;
import de.willuhn.jameica.system.Application;
import de.willuhn.logging.Logger;
import de.willuhn.util.ApplicationException;

/**
 * Anzeigen von Dokumenten
 */
public class DokumentShowAction implements Action
{
  public void handleAction(Object context) throws ApplicationException
  {
    if (context == null || !(context instanceof AbstractDokument))
    {
      throw new ApplicationException(JVereinPlugin.getI18n().tr(
          "Kein Dokument ausgew�hlt"));
    }
    try
    {
      AbstractDokument ad = (AbstractDokument) context;
      if (ad.isNewObject())
      {
        return;
      }
      QueryMessage qm = new QueryMessage(ad.getUUID(), null);
      Application.getMessagingFactory()
          .getMessagingQueue("jameica.messaging.getmeta").sendSyncMessage(qm);
      Map map = (Map) qm.getData();

      qm = new QueryMessage(ad.getUUID(), null);
      Application.getMessagingFactory()
          .getMessagingQueue("jameica.messaging.get").sendSyncMessage(qm);
      byte[] data = (byte[]) qm.getData();
      final File file = new File(System.getProperty("java.io.tmpdir") + "/"
          + map.get("filename"));
      FileOutputStream fos = new FileOutputStream(file);
      fos.write(data);
      fos.close();
      file.deleteOnExit();
      GUI.getDisplay().asyncExec(new Runnable()
      {
        public void run()
        {
          try
          {
            new Program().handleAction(file);
          }
          catch (ApplicationException ae)
          {
            Application.getMessagingFactory().sendMessage(
                new StatusBarMessage(ae.getLocalizedMessage(),
                    StatusBarMessage.TYPE_ERROR));
          }
        }
      });
    }
    catch (Exception e)
    {
      String fehler = JVereinPlugin.getI18n().tr(
          "Fehler beim L�schen des Dokuments");
      GUI.getStatusBar().setErrorText(fehler);
      Logger.error(fehler, e);
    }
  }
}
