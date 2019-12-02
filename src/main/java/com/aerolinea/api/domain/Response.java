package com.aerolinea.api.domain;

public class Response<T> {

	/** Indica el estado de la transaccion */
	private int status;
	/** Mensaje informativo para el usuario */
	private String userMessage;
	/** Mensaje informativo para los desarrolladores */
	private String developerMessage;
	/** Codigo de error dentro del sistema */
	private String errorCode;
	/** Url para consultar mas informacion acerca del error */
	private String moreInfo;
	/** Objeto con la respuesta de la transaccion */
	private T data;

	/**
	 * Metodo constructor
	 */
	public Response() {
		// Empty constructor
	}

	/**
	 * Metodo constructor
	 * 
	 * @param status           Estado de la transaccion
	 * @param userMessage      Mensaje para el usuario
	 * @param developerMessage Mensaje para el desarrollador
	 * @param errorCode        Codigo de error
	 * @param moreInfo         Url de consulta de informacion
	 * @param data             Datos de la transaccion
	 */
	public Response(int status, String userMessage, String developerMessage, String errorCode, String moreInfo,
			T data) {
		this.status = status;
		this.userMessage = userMessage;
		this.developerMessage = developerMessage;
		this.errorCode = errorCode;
		this.moreInfo = moreInfo;
		this.data = data;
	}

	/**
	 * Metodo constructor
	 * 
	 * @param status           Estado de la transaccion
	 * @param userMessage      Mensaje para el usuario
	 * @param developerMessage Mensaje para el desarrollador
	 * @param errorCode        Codigo de error
	 * @param moreInfo         Url de consulta de informacion
	 */
	public Response(int status, String userMessage, String developerMessage, String errorCode, String moreInfo) {
		this.status = status;
		this.userMessage = userMessage;
		this.developerMessage = developerMessage;
		this.errorCode = errorCode;
		this.moreInfo = moreInfo;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the userMessage
	 */
	public String getUserMessage() {
		return userMessage;
	}

	/**
	 * @param userMessage the userMessage to set
	 */
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	/**
	 * @return the developerMessage
	 */
	public String getDeveloperMessage() {
		return developerMessage;
	}

	/**
	 * @param developerMessage the developerMessage to set
	 */
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the moreInfo
	 */
	public String getMoreInfo() {
		return moreInfo;
	}

	/**
	 * @param moreInfo the moreInfo to set
	 */
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", userMessage=" + userMessage + ", developerMessage=" + developerMessage
				+ ", moreInfo=" + moreInfo + ", data=" + (data != null ? data.toString() : "") + "]";
	}

}
