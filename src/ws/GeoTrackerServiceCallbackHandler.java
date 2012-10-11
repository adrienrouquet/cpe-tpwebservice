
/**
 * GeoTrackerServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.5  Built on : May 28, 2011 (08:30:56 CEST)
 */

    package ws;

    /**
     *  GeoTrackerServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GeoTrackerServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GeoTrackerServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GeoTrackerServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getMaxSpeed method
            * override this method for handling normal response from getMaxSpeed operation
            */
           public void receiveResultgetMaxSpeed(
                    ws.GeoTrackerServiceStub.GetMaxSpeedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMaxSpeed operation
           */
            public void receiveErrorgetMaxSpeed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getLastPosition method
            * override this method for handling normal response from getLastPosition operation
            */
           public void receiveResultgetLastPosition(
                    ws.GeoTrackerServiceStub.GetLastPositionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLastPosition operation
           */
            public void receiveErrorgetLastPosition(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNumbers method
            * override this method for handling normal response from getNumbers operation
            */
           public void receiveResultgetNumbers(
                    ws.GeoTrackerServiceStub.GetNumbersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNumbers operation
           */
            public void receiveErrorgetNumbers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNames method
            * override this method for handling normal response from getNames operation
            */
           public void receiveResultgetNames(
                    ws.GeoTrackerServiceStub.GetNamesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNames operation
           */
            public void receiveErrorgetNames(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getIds method
            * override this method for handling normal response from getIds operation
            */
           public void receiveResultgetIds(
                    ws.GeoTrackerServiceStub.GetIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getIds operation
           */
            public void receiveErrorgetIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRelease method
            * override this method for handling normal response from getRelease operation
            */
           public void receiveResultgetRelease(
                    ws.GeoTrackerServiceStub.GetReleaseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRelease operation
           */
            public void receiveErrorgetRelease(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setRelease method
            * override this method for handling normal response from setRelease operation
            */
           public void receiveResultsetRelease(
                    ws.GeoTrackerServiceStub.SetReleaseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setRelease operation
           */
            public void receiveErrorsetRelease(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPositions method
            * override this method for handling normal response from getPositions operation
            */
           public void receiveResultgetPositions(
                    ws.GeoTrackerServiceStub.GetPositionsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPositions operation
           */
            public void receiveErrorgetPositions(java.lang.Exception e) {
            }
                


    }
    