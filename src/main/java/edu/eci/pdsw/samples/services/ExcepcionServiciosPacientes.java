/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.services;

/**
 *
 * @author hcadavid
 */
public class ExcepcionServiciosPacientes extends Exception {
    
    public static final String PACIENTE_EXISTENTE="El paciente ya se encuentra registrado";
    public static final String PACIENTE_IDINVALIDO="El numero de documento no es valido para el paciente";
    public static final String PACIENTE_NO_EXISTENTE="El paciente no se encuentra registrado en la base de datos";
    public static final String EROR_CARGANDO_PACIENTES="No se pudieron cargar todos los pacientes";
    
    public ExcepcionServiciosPacientes() {
    }

    public ExcepcionServiciosPacientes(String message) {
        super(message);
    }

    public ExcepcionServiciosPacientes(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionServiciosPacientes(Throwable cause) {
        super(cause);
    }
    
}
