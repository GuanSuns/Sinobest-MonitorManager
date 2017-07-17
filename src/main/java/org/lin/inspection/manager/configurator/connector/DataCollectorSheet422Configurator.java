package org.lin.inspection.manager.configurator.connector;

import org.lin.inspection.manager.parser.connector.ConnectorParser;
import org.lin.inspection.manager.parser.connector.HostConfig;
import org.suns.data.collector.config.sheet422.Sheet422CoreConfig;
import org.suns.data.collector.config.sheet422.Sheet422PersonalConfig;

import java.util.ArrayList;

/**
 * Created by guanl on 7/17/2017.
 */
public class DataCollectorSheet422Configurator {
    private ConnectorParser connectorParser;

    public DataCollectorSheet422Configurator(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public DataCollectorSheet422Configurator() {
        this.connectorParser = null;
    }

    public ConnectorParser getConnectorParser() {
        return connectorParser;
    }

    public void setConnectorParser(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public void configurePersonal() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        ArrayList<HostConfig> coreHosts = connectorParser.getDatabaseInspectionConfig()
                .getPersonal().getCoreHosts();
        String[] hosts = new String[1];
        String[] users = new String[1];
        String[] passwords = new String[1];
        String[] sids = new String[1];
        int[] ports = new int[1];
        copyFromHostConfigArray(coreHosts, hosts, users, passwords, ports, sids);
        Sheet422PersonalConfig.setInspectedHosts(hosts);
        Sheet422PersonalConfig.setPasswords(passwords);
        Sheet422PersonalConfig.setPorts(ports);
        Sheet422PersonalConfig.setUsers(users);
        Sheet422PersonalConfig.setSid(sids);
    }

    public void configureCore() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        ArrayList<HostConfig> taxationHostConfigs = connectorParser.getDatabaseInspectionConfig()
                .getCore().getTaxationHosts();
        String[] taxationHosts = new String[1];
        String[] taxationUsers = new String[1];
        String[] taxationPasswords = new String[1];
        String[] taxationSids = new String[1];
        int[] taxationPorts = new int[1];
        copyFromHostConfigArray(taxationHostConfigs, taxationHosts, taxationUsers, taxationPasswords, taxationPorts, taxationSids);
        Sheet422CoreConfig.setInspectedHosts2(taxationHosts);
        Sheet422CoreConfig.setPasswords2(taxationPasswords);
        Sheet422CoreConfig.setPorts2(taxationPorts);
        Sheet422CoreConfig.setUsers2(taxationUsers);
        Sheet422CoreConfig.setSid2(taxationSids);

        ArrayList<HostConfig> queryHostConfigs = connectorParser.getDatabaseInspectionConfig()
                .getCore().getQueryHosts();
        String[] queryHosts = new String[1];
        String[] queryUsers = new String[1];
        String[] queryPasswords = new String[1];
        String[] querySids = new String[1];
        int[] queryPorts = new int[1];
        copyFromHostConfigArray(queryHostConfigs, queryHosts, queryUsers, queryPasswords, queryPorts, querySids);
        Sheet422CoreConfig.setInspectedHosts3(queryHosts);
        Sheet422CoreConfig.setPasswords3(queryPasswords);
        Sheet422CoreConfig.setPorts3(queryPorts);
        Sheet422CoreConfig.setUsers3(queryUsers);
        Sheet422CoreConfig.setSid3(querySids);

        ArrayList<HostConfig> integrationHostConfigs = connectorParser.getDatabaseInspectionConfig()
                .getCore().getIntegrationHosts();
        String[] integrationHosts = new String[1];
        String[] integrationUsers = new String[1];
        String[] integrationPasswords = new String[1];
        String[] integrationSids = new String[1];
        int[] integrationPorts = new int[1];
        copyFromHostConfigArray(integrationHostConfigs, integrationHosts, integrationUsers, integrationPasswords, integrationPorts, integrationSids);
        Sheet422CoreConfig.setInspectedHosts4(integrationHosts);
        Sheet422CoreConfig.setPasswords4(integrationPasswords);
        Sheet422CoreConfig.setPorts4(integrationPorts);
        Sheet422CoreConfig.setUsers4(integrationUsers);
        Sheet422CoreConfig.setSid4(integrationSids);
    }

    private void copyFromHostConfigArray(ArrayList<HostConfig> hostsConfig
            ,String[] hosts, String[] users
            , String[] passwords, int[] ports, String[] sids){
        final int size = 1;

        for(int i=0; i<size; i++){
            hosts[i] = hostsConfig.get(i).getIp();
            users[i] = hostsConfig.get(i).getUser();
            passwords[i] = hostsConfig.get(i).getPassword();
            ports[i] = hostsConfig.get(i).getPort();
            sids[i] = hostsConfig.get(i).getSid();
        }
    }
}
