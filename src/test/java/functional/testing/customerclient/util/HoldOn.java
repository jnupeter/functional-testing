/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package functional.testing.customerclient.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * 
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 * @version %I%,%G%
 * @since 1.0
 */
public class HoldOn {

    private HoldOn(){
    }
    
    public static void seconds(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HoldOn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
