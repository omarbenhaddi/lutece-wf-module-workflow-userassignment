/*
 * Copyright (c) 2002-2021, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.workflow.modules.userassignment.business.information;

import fr.paris.lutece.test.LuteceTestCase;
import fr.paris.lutece.util.sql.DAOUtil;

public class UserTaskInformationBusinessTest extends LuteceTestCase
{
    public void testCRUD( )
    {
        UserTaskInformation info = new UserTaskInformation( 1, 1 );
        info.add( UserTaskInformation.TASK_INFORMATION_ASSIGNED_USER_NAME, "John" );
        info.add( UserTaskInformation.TASK_INFORMATION_ASSIGNED_USER_LASTNAME, "Doe" );

        UserTaskInformationHome.create( info );

        UserTaskInformation loaded = UserTaskInformationHome.find( 1, 1 );

        assertEquals( info.get( UserTaskInformation.TASK_INFORMATION_ASSIGNED_USER_NAME ),
                loaded.get( UserTaskInformation.TASK_INFORMATION_ASSIGNED_USER_NAME ) );
        assertEquals( info.get( UserTaskInformation.TASK_INFORMATION_ASSIGNED_USER_LASTNAME ),
                loaded.get( UserTaskInformation.TASK_INFORMATION_ASSIGNED_USER_LASTNAME ) );

        clearTable( );
    }

    private void clearTable( )
    {
        try ( DAOUtil daoUtil = new DAOUtil( "DELETE FROM workflow_task_assign_user_information" ) )
        {
            daoUtil.executeUpdate( );
        }
    }
}
