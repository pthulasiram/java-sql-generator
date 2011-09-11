/*
 * Copyright (c) 2011, Stanislav Muhametsin. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.sql.generation.implementation.grammar.common;

import org.sql.generation.api.common.NullArgumentException;
import org.sql.generation.api.grammar.common.TableNameFunction;
import org.sql.generation.api.grammar.literals.SQLFunctionLiteral;

/**
 * 
 * @author 2011 Stanislav Muhametsin
 */
public class TableNameFunctionImpl extends TableNameAbstractImpl<TableNameFunction>
    implements TableNameFunction
{

    private final SQLFunctionLiteral _function;

    public TableNameFunctionImpl( String schemaName, SQLFunctionLiteral function )
    {
        this( TableNameFunction.class, schemaName, function );
    }

    protected TableNameFunctionImpl( Class<? extends TableNameFunction> implClass, String schemaName,
        SQLFunctionLiteral function )
    {
        super( implClass, schemaName );
        NullArgumentException.validateNotNull( "SQL function", function );

        this._function = function;
    }

    public SQLFunctionLiteral getFunction()
    {
        return this._function;
    }

    @Override
    protected boolean doesEqual( TableNameFunction another )
    {
        return super.doesEqual( another ) && this._function.equals( another.getFunction() );
    }

}
