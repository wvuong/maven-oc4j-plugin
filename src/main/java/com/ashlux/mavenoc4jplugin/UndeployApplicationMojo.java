package com.ashlux.mavenoc4jplugin;

/**
 * Undeploy application from OC4J.
 *
 * @goal undeployApplication
 */
public class UndeployApplicationMojo extends AbstractOc4jMojo {
  /**
   * Application name when deploying the ear.
   *
   * @parameter expression="${oc4j.deploymentName}" default-value="${project.artifactId}"
   */
  private String applicationName;

  protected String buildCommand() {
    String command = getJavaHome() + "/bin/java -jar " + getJ2eeHome() + "/" + getAdminJar() + " " +
        getConnectionUri() + " " + getUsername() + " " + getPassword() +
        " -undeploy " + applicationName;
    getLog().debug("Going to run command [" + command + "].");
    return command;
  }

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }
}
